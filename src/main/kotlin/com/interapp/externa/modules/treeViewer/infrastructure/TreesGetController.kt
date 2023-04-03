package com.interapp.externa.modules.treeViewer.infrastructure

import com.interapp.externa.core.tree.application.TreeSearch
import com.interapp.externa.core.tree.domain.Tree
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/treeViewer")
class TreesGetController(private val treeSearch: TreeSearch) {

    @GetMapping("/trees")
    fun getAllTrees(): List<Tree> {
        return treeSearch.findTrees().sortedBy { tree: Tree -> tree.id }
    }

    @GetMapping("/trees/adoption/{id}")
    fun getTreesByAdoptionId(@PathVariable id: Long): Tree {
        return treeSearch.findTreeByAdoptionId(id)
    }
}
