package com.interapp.externa.core.tree.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TreeRepository: JpaRepository<Tree, Long> {
    @Query("select t from Adoption a, Tree t where a.id = ?1 and a.treeId = t.id")
    fun findTreeByAdoptionId(id: Long): Tree
}
