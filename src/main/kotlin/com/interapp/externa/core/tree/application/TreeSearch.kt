package com.interapp.externa.core.tree.application

import com.interapp.externa.core.tree.domain.Tree
import com.interapp.externa.core.tree.domain.TreeRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TreeSearch(private val treeRepository: TreeRepository) {
    fun findTreeById(id: Long): Tree {
        return treeRepository.findById(id)
            .orElseThrow {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "Tree not found!")
            }
    }

    fun findTreeByAdoptionId(id: Long): Tree {
        return treeRepository.findTreeByAdoptionId(id)
    }
    fun findTrees(): MutableList<Tree> {
        return treeRepository.findAll()
    }
}
