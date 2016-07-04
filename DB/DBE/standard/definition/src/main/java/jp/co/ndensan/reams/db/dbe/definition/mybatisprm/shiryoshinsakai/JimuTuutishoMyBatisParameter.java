/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局追加資料鑑情報のMyBatisParameterです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JimuTuutishoMyBatisParameter implements IMyBatisParameter {

    private RString shinsakaiKaisaiNo;
    private RString shinsakaiIinCode;
    private RString shujiiIryokikanCode;
    private RString shujiiCode;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString ninteiChosaItakusakiCode;
    private RString ninteiChosainCode;
    private RString sonotaKikanCode;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     */
    public JimuTuutishoMyBatisParameter(RString shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }
}
