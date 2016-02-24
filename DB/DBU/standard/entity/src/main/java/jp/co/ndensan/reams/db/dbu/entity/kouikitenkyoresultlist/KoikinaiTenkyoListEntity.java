/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域内転居結果一覧表帳票データ作成入力
 *
 *
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiTenkyoListEntity {

    private LasdecCode 市町村コード;
    private RString 市町村名;
    private List<KoikinaiTenkyoEntity> entity;

}
