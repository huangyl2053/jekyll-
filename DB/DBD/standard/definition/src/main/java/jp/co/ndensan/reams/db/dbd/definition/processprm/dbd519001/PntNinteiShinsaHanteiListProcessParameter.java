/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519001.PntNinteiShinsaHanteiListMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定審査判定依頼一覧表発行_バッチ処理パラメータクラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PntNinteiShinsaHanteiListProcessParameter implements IBatchProcessParameter {

    private RString 認定申請IF種類;
    private RString 証記載保険者番号;
    private LasdecCode 市町村コード;
    private HihokenshaNo 被保険者番号;
    private RDateTime 抽出開始日時;
    private RDateTime 抽出終了日時;
    private RString 編集状況フラグ;

    /**
     * Mybatisのパラメータを作成します。
     *
     * @return PntNinteiShinsaHanteiListMybatisParameter
     */
    public PntNinteiShinsaHanteiListMybatisParameter toMybatisParameter() {
        return new PntNinteiShinsaHanteiListMybatisParameter(市町村コード, new ShoKisaiHokenshaNo(証記載保険者番号));
    }
}
