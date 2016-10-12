/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 認定審査判定依頼一覧表発行(バッチ) SQLパラメータクラスです。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PntNinteiShinsaHanteiListMybatisParameter implements IMyBatisParameter {

    private final LasdecCode 市町村コード;
    private final ShoKisaiHokenshaNo 証記載保険者番号;

    /**
     * コンストラクタ。
     *
     * @param 市町村コード LasdecCode
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     */
    public PntNinteiShinsaHanteiListMybatisParameter(LasdecCode 市町村コード, ShoKisaiHokenshaNo 証記載保険者番号) {
        this.市町村コード = 市町村コード;
        this.証記載保険者番号 = 証記載保険者番号;
    }

}
