package com.interapp.externa.modules.login

import com.interapp.externa.core.adoption.application.AdoptionService
import com.interapp.externa.core.adoption.application.search.SearchAdoptionById
import com.interapp.externa.core.bdcLocation.application.BDCLocationSearch
import com.interapp.externa.core.censusAddress.application.CensusAddressSearch
import com.interapp.externa.core.consent.application.ConsentSearch
import com.interapp.externa.core.consent.application.ConsentService
import com.interapp.externa.core.electoralRollAddress.application.ElectoralRollAddressSearch
import com.interapp.externa.core.godfather.application.GodfatherService
import com.interapp.externa.core.godfather.application.search.SearchGodfatherById
import com.interapp.externa.core.godfather.application.search.SearchGodfatherByName
import com.interapp.externa.core.newBorn.application.NewbornSearch
import com.interapp.externa.core.representative.application.RepresentativeSearch
import com.interapp.externa.core.representative.domain.Representative
import com.interapp.externa.core.tree.application.TreeSearch
import com.interapp.externa.modules.login.application.AuthService
import com.interapp.externa.modules.searchByEntity.application.SearchByAdoption
import com.interapp.externa.modules.searchByEntity.application.SearchByGodfather
import com.interapp.externa.modules.searchByEntity.application.utils.AdoptionFilterUtils
import com.interapp.externa.modules.searchByEntity.application.utils.GodfatherFilterUtils
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import com.ninjasquad.springmockk.MockkBean
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get



@WebMvcTest
class WebTierTests (@Autowired val mockMvc: MockMvc) {
    private val url = "/api/v1/auth/signin/representatives"

    @MockkBean
    private lateinit var representativeSearch: RepresentativeSearch

    @MockkBean
    private lateinit var adoptionService: AdoptionService

    @MockkBean
    private lateinit var newbornSearch: NewbornSearch

    @MockkBean
    private lateinit var bdcLocationSearch: BDCLocationSearch

    @MockkBean
    private lateinit var electoralRollAddressSearch: ElectoralRollAddressSearch

    @MockkBean
    private lateinit var godfatherService: GodfatherService

    @MockkBean
    private lateinit var searchGodfatherByName: SearchGodfatherByName

    @MockkBean
    private lateinit var consentService: ConsentService

    @MockkBean
    private lateinit var searchByGodfather: SearchByGodfather

    @MockkBean
    private lateinit var searchAdoptionById: SearchAdoptionById

    @MockkBean
    private lateinit var treeSearch: TreeSearch

    @MockkBean
    private lateinit var consentSearch: ConsentSearch

    @MockkBean
    private lateinit var censusAddressSearch: CensusAddressSearch

    @MockkBean
    private lateinit var authService: AuthService

    @MockkBean
    private lateinit var searchGodfatherById: SearchGodfatherById

    @MockkBean
    private lateinit var searchByAdoption: SearchByAdoption

    @MockkBean
    private lateinit var adoptionFilterUtils: AdoptionFilterUtils

    @MockkBean
    private lateinit var godfatherFilterUtils: GodfatherFilterUtils

    @Test
    @WithMockUser()
    fun `find representatives`() {
        every { representativeSearch.findRepresentatives() } returns
                listOf(Representative("Jose", "Visa", "Crespo", "1962-08-04", "47825645L", 1),
                    Representative("Gemma", "Pascual", "Sol", "1962-12-13","85749612T", 2)
                )

        mockMvc.get(url)
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }
            .andExpect {
                jsonPath("\$.[0].name") { value("Jose") }
                jsonPath("\$.[0].nifNie") { value("47825645L") }
                jsonPath("\$.[1].birthday") { value("1962-12-13") }
                jsonPath("\$.[1].nifNie") { value("85749612T") }
            }
        verify(exactly = 1) { representativeSearch.findRepresentatives() }
    }
}
