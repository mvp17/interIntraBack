package com.interapp.externa.modules.searchByEntity.domain

data class FilterJSONAdoptionDTO(
    var adoptionId: String?,
    var treeName: String?,
    var treeSpecies: String?,
    var adoptionFromDate: String?,
    var adoptionToDate: String?,
    var adoptionDistrict: String?,
    var adoptionNeigh: String?
) {
    fun hasAdoptionId(): Boolean {
        return !adoptionId.isNullOrEmpty()
    }
    fun hasTreeName(): Boolean {
        return !treeName.isNullOrEmpty()
    }
    fun hasTreeSpecies(): Boolean {
        return !treeSpecies.isNullOrEmpty()
    }
    fun hasAdoptionFromDate(): Boolean {
        return !adoptionFromDate.isNullOrEmpty()
    }
    fun hasAdoptionToDate(): Boolean {
        return !adoptionToDate.isNullOrEmpty()
    }
    fun hasAdoptionDistrict(): Boolean {
        return !adoptionDistrict.isNullOrEmpty()
    }
    fun hasAdoptionNeigh(): Boolean {
        return !adoptionNeigh.isNullOrEmpty()
    }
}
