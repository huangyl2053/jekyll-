/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い支給（不支給）決定通知書一括作成_処理日付管理マスタ取得用MyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SelectMaxEdabanParameter implements IMyBatisParameter {

    private SubGyomuCode subGyomuCode;
    private LasdecCode shichosonCode;
    private RString shoriName;
    private RString shoriEdaban;
    private FlexibleYear nendo;

    /**
     * コンストラクタです。
     *
     * @param subGyomuCode サブ業務コード
     * @param shichosonCode 市町村コード
     * @param shoriName 処理名
     * @param shoriEdaban 処理枝番
     * @param nendo 年度
     */
    public SelectMaxEdabanParameter(SubGyomuCode subGyomuCode, LasdecCode shichosonCode, RString shoriName,
            RString shoriEdaban, FlexibleYear nendo) {
        this.subGyomuCode = subGyomuCode;
        this.shichosonCode = shichosonCode;
        this.shoriName = shoriName;
        this.shoriEdaban = shoriEdaban;
        this.nendo = nendo;
    }
}