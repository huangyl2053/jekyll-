/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.entity.db.relate.taishouwaritsuke;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査会割当用パラメーターエンティティー
 * 
 * @author n3213
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ParamEntity {
    private LasdecCode 市町村コード;
    private Code 入所施設コード;
    private Code 調査委託先コード;
    private Code 調査員コード;
    private Code 主治医医療機関コード;
    private Code 主治医コード;
}
