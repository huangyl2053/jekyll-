/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shinsakaikaisai;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 介護認定審査会共有一覧の項目定義クラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiKaisaiMode implements Serializable {

    private List<ShinsakaiKaisai> 審査会一覧Grid;
}
