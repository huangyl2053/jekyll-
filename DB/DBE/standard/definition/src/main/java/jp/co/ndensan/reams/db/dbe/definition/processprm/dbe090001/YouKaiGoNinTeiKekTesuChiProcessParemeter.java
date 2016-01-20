/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.dbe090001;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe090001.YouKaiGoNinTeiKekTesuChiMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医への結果通知書のMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class YouKaiGoNinTeiKekTesuChiProcessParemeter implements IBatchProcessParameter {

    private RString nijiHanteiYMDFrom;
    private RString nijiHanteiYMDTo;
    private RString maDaNyuRyoKu;
    private RString shuJiiJyouHou;
    private RString shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
    private RString shishoCode;
    private RString ninteiJohoTeikyoYMD;

    /**
     * コンストラクタ作成です。
     *
     * @param nijiHanteiYMDFrom
     * @param nijiHanteiYMDTo
     * @param maDaNyuRyoKu
     * @param shuJiiJyouHou
     * @param shinseishoKanriNo
     * @param shoKisaiHokenshaNo
     * @param shishoCode
     * @param ninteiJohoTeikyoYMD
     */
    public YouKaiGoNinTeiKekTesuChiProcessParemeter(RString nijiHanteiYMDFrom,
            RString nijiHanteiYMDTo,
            RString maDaNyuRyoKu,
            RString shuJiiJyouHou,
            RString shinseishoKanriNo,
            RString shoKisaiHokenshaNo,
            RString shishoCode,
            RString ninteiJohoTeikyoYMD) {
        this.nijiHanteiYMDFrom = nijiHanteiYMDFrom;
        this.nijiHanteiYMDTo = nijiHanteiYMDTo;
        this.maDaNyuRyoKu = maDaNyuRyoKu;
        this.shuJiiJyouHou = shuJiiJyouHou;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.shishoCode = shishoCode;
        this.ninteiJohoTeikyoYMD = ninteiJohoTeikyoYMD;
    }

    /**
     * 調査委託先・調査員一覧表のMybatisパラメータークラス作成
     *
     * @return ItakusakiChosainIchiranMybitisParamter
     */
    public YouKaiGoNinTeiKekTesuChiMybitisParamter toMybitisParameter() {
        return YouKaiGoNinTeiKekTesuChiMybitisParamter.create主治医への結果通知書Parameter(nijiHanteiYMDFrom,
                nijiHanteiYMDTo,
                maDaNyuRyoKu,
                shuJiiJyouHou,
                shinseishoKanriNo,
                shoKisaiHokenshaNo,
                shishoCode,
                ninteiJohoTeikyoYMD);
    }
}
