package com.interapp.externa.app.treeViewer.application

import com.interapp.externa.app.treeViewer.domain.Tree
import com.interapp.externa.app.treeViewer.domain.TreeRepository
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
    fun findTrees(): MutableList<Tree> {
        return treeRepository.findAll()
    }
}
