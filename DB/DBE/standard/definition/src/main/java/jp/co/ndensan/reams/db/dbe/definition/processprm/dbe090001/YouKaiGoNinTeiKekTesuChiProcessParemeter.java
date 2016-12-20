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
 *
 * @reamsid_L DBE-0220-030 wangkun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public final class YouKaiGoNinTeiKekTesuChiProcessParemeter implements IBatchProcessParameter {

    private RString nijiHanteiYMDFrom;
    private RString nijiHanteiYMDTo;
    private RString maDaNyuRyoKu;
    private RString shuJiiJyouHou;
    private RString shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
    private RString shishoCode;
    private RString ninteiJohoTeikyoYMD;
    private RString shichosonCode;
    private boolean useShoKisaiHokenshaNo;

    /**
     * コンストラクタ作成です。
     *
     * @param nijiHanteiYMDFrom 二次判定開始年月日
     * @param nijiHanteiYMDTo 二次判定終了年月日
     * @param maDaNyuRyoKu 未だ入力
     * @param shuJiiJyouHou 主治医情報
     * @param shinseishoKanriNo 申請書管理番号
     * @param shoKisaiHokenshaNo 初期再保険者番号
     * @param shishoCode 支所コード
     * @param ninteiJohoTeikyoYMD 認定情報提供年月日
     * @param shichosonCode 市町村コード
     * @param useShoKisaiHokenshaNo useShoKisaiHokenshaNo
     */
    public YouKaiGoNinTeiKekTesuChiProcessParemeter(RString nijiHanteiYMDFrom,
            RString nijiHanteiYMDTo,
            RString maDaNyuRyoKu,
            RString shuJiiJyouHou,
            RString shinseishoKanriNo,
            RString shoKisaiHokenshaNo,
            RString shishoCode,
            RString ninteiJohoTeikyoYMD,
            RString shichosonCode,
            boolean useShoKisaiHokenshaNo) {
        this.nijiHanteiYMDFrom = nijiHanteiYMDFrom;
        this.nijiHanteiYMDTo = nijiHanteiYMDTo;
        this.maDaNyuRyoKu = maDaNyuRyoKu;
        this.shuJiiJyouHou = shuJiiJyouHou;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.shishoCode = shishoCode;
        this.ninteiJohoTeikyoYMD = ninteiJohoTeikyoYMD;
        this.shichosonCode = shichosonCode;
        this.useShoKisaiHokenshaNo = useShoKisaiHokenshaNo;
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
                ninteiJohoTeikyoYMD,
                useShoKisaiHokenshaNo);
    }
}
