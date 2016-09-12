/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.atenasealcreate;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛名シール作成のMyBatisパラメータ。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AtenaSealCreateMybatisParameter implements IMyBatisParameter {

    private final RString chuushutsutaishousha;
    private final RString chuyshutsukukantxt;
    private final FlexibleDate chuushutsukikankaishibi;
    private final FlexibleDate chuushutsukikanshuuryoubi;
    private final RString shikakukubun;
    private final RString shichousonshitei;
    private final RString saiyuusenjyusho;
    private final RString keishou;
    private final RString hitemotsubangouhyouji;
    private final boolean iskatagaki;
    private final boolean isshichosonmeisho;
    private final boolean istodofukenmeisho;
    private final boolean isgunmeisho;
    private final Long shutsutuokujyunid;
    private final RString gyoumucode;
    private final boolean is資格区分_全て;
    private final boolean is年齢到達日;
    private final boolean has市町村指定;
    private final FlexibleDate kankaishibi_第１号;
    private final FlexibleDate shuuryoubi_第１号;
    private final FlexibleDate kankaishibi_第２号;
    private final FlexibleDate shuuryoubi_第２号;
    private final List<RString> kubun_1;
    private final List<RString> kubun_2;
    private final List<RString> shubetsu_1;
    private final List<RString> shubetsu_2;
    private final boolean is第1号開始年月日;
    private final boolean is第2号開始年月日;
    private final boolean is送付先または代納人;
    private final boolean is市町村指定;
    private final boolean is抽出対象者1;
    private final boolean isDBA業務コード;
    private final boolean is受給認定申請中を除く;
    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;

    /**
     * コンストラクタです。
     *
     * @param chuushutsutaishousha chuushutsutaishousha
     * @param chuyshutsukukantxt chuyshutsukukantxt
     * @param chuushutsukikankaishibi chuushutsukikankaishibi
     * @param chuushutsukikanshuuryoubi chuushutsukikanshuuryoubi
     * @param shikakukubun shikakukubun
     * @param shichousonshitei shichousonshitei
     * @param saiyuusenjyusho saiyuusenjyusho
     * @param keishou keishou
     * @param hitemotsubangouhyouji hitemotsubangouhyouji
     * @param iskatagaki iskatagaki
     * @param isshichosonmeisho isshichosonmeisho
     * @param istodofukenmeisho istodofukenmeisho
     * @param isgunmeisho isgunmeisho
     * @param shutsutuokujyunid shutsutuokujyunid
     * @param gyoumucode gyoumucode
     * @param is資格区分_全て is資格区分_全て
     * @param is年齢到達日 is年齢到達日
     * @param has市町村指定 has市町村指定
     * @param kankaishibi_第１号 kankaishibi_第１号
     * @param shuuryoubi_第１号 shuuryoubi_第１号
     * @param kankaishibi_第２号 kankaishibi_第２号
     * @param shuuryoubi_第２号 shuuryoubi_第２号
     * @param kubun_1 kubun_1
     * @param kubun_2 kubun_2
     * @param shubetsu_1 shubetsu_1
     * @param shubetsu_2 shubetsu_2
     * @param is第1号開始年月日 is第1号開始年月日
     * @param psmShikibetsuTaisho 宛名識別対象抽出PSM
     * @param is送付先または代納人 is送付先または代納人
     * @param is市町村指定 is市町村指定
     * @param is抽出対象者1 is抽出対象者1
     * @param isDBA業務コード isDBA業務コード
     * @param is受給認定申請中を除く is受給認定申請中を除く
     * @param is第2号開始年月日 is第2号開始年月日
     * @param psmAtesaki 宛先抽出PSM
     */
    protected AtenaSealCreateMybatisParameter(
            RString chuushutsutaishousha,
            RString chuyshutsukukantxt,
            FlexibleDate chuushutsukikankaishibi,
            FlexibleDate chuushutsukikanshuuryoubi,
            RString shikakukubun,
            RString shichousonshitei,
            RString saiyuusenjyusho,
            RString keishou,
            RString hitemotsubangouhyouji,
            boolean iskatagaki,
            boolean isshichosonmeisho,
            boolean istodofukenmeisho,
            boolean isgunmeisho,
            Long shutsutuokujyunid,
            RString gyoumucode,
            boolean is資格区分_全て,
            boolean is年齢到達日,
            boolean has市町村指定,
            FlexibleDate kankaishibi_第１号,
            FlexibleDate shuuryoubi_第１号,
            FlexibleDate kankaishibi_第２号,
            FlexibleDate shuuryoubi_第２号,
            List<RString> kubun_1,
            List<RString> kubun_2,
            List<RString> shubetsu_1,
            List<RString> shubetsu_2,
            boolean is第1号開始年月日,
            boolean is第2号開始年月日,
            boolean is送付先または代納人,
            boolean is市町村指定,
            boolean is抽出対象者1,
            boolean isDBA業務コード,
            boolean is受給認定申請中を除く,
            RString psmShikibetsuTaisho,
            RString psmAtesaki
    ) {
        this.chuushutsutaishousha = chuushutsutaishousha;
        this.chuyshutsukukantxt = chuyshutsukukantxt;
        this.chuushutsukikankaishibi = chuushutsukikankaishibi;
        this.chuushutsukikanshuuryoubi = chuushutsukikanshuuryoubi;
        this.shikakukubun = shikakukubun;
        this.shichousonshitei = shichousonshitei;
        this.saiyuusenjyusho = saiyuusenjyusho;
        this.keishou = keishou;
        this.hitemotsubangouhyouji = hitemotsubangouhyouji;
        this.iskatagaki = iskatagaki;
        this.isshichosonmeisho = isshichosonmeisho;
        this.istodofukenmeisho = istodofukenmeisho;
        this.isgunmeisho = isgunmeisho;
        this.shutsutuokujyunid = shutsutuokujyunid;
        this.gyoumucode = gyoumucode;
        this.is資格区分_全て = is資格区分_全て;
        this.is年齢到達日 = is年齢到達日;
        this.has市町村指定 = has市町村指定;
        this.kankaishibi_第１号 = kankaishibi_第１号;
        this.shuuryoubi_第１号 = shuuryoubi_第１号;
        this.kankaishibi_第２号 = kankaishibi_第２号;
        this.shuuryoubi_第２号 = shuuryoubi_第２号;
        this.kubun_1 = kubun_1;
        this.kubun_2 = kubun_2;
        this.shubetsu_1 = shubetsu_1;
        this.shubetsu_2 = shubetsu_2;
        this.is第1号開始年月日 = is第1号開始年月日;
        this.is第2号開始年月日 = is第2号開始年月日;
        this.is送付先または代納人 = is送付先または代納人;
        this.is市町村指定 = is市町村指定;
        this.is抽出対象者1 = is抽出対象者1;
        this.isDBA業務コード = isDBA業務コード;
        this.is受給認定申請中を除く = is受給認定申請中を除く;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
    }

    /**
     * パラメータを作成します。
     *
     * @param chuushutsutaishousha chuushutsutaishousha
     * @param chuyshutsukukantxt chuyshutsukukantxt
     * @param chuushutsukikankaishibi chuushutsukikankaishibi
     * @param chuushutsukikanshuuryoubi chuushutsukikanshuuryoubi
     * @param shikakukubun shikakukubun
     * @param shichousonshitei shichousonshitei
     * @param saiyuusenjyusho saiyuusenjyusho
     * @param keishou keishou
     * @param hitemotsubangouhyouji hitemotsubangouhyouji
     * @param iskatagaki iskatagaki
     * @param isshichosonmeisho isshichosonmeisho
     * @param istodofukenmeisho istodofukenmeisho
     * @param isgunmeisho isgunmeisho
     * @param shutsutuokujyunid shutsutuokujyunid
     * @param gyoumucode gyoumucode
     * @param is資格区分_全て is資格区分_全て
     * @param is年齢到達日 is年齢到達日
     * @param has市町村指定 has市町村指定
     * @param kankaishibi_第１号 kankaishibi_第１号
     * @param shuuryoubi_第１号 shuuryoubi_第１号
     * @param kankaishibi_第２号 kankaishibi_第２号
     * @param shuuryoubi_第２号 shuuryoubi_第２号
     * @param psmShikibetsuTaisho 宛名識別対象抽出PSM
     * @param psmAtesaki 宛先抽出PSM
     * @param kubun_1 kubun_1
     * @param shubetsu_2 shubetsu_2
     * @param is第1号開始年月日 is第1号開始年月日
     * @param is第2号開始年月日 is第2号開始年月日
     * @param is送付先または代納人 is送付先または代納人
     * @param is市町村指定 is市町村指定
     * @param is抽出対象者1 is抽出対象者1
     * @param isDBA業務コード isDBA業務コード
     * @param is受給認定申請中を除く is受給認定申請中を除く
     * @param kubun_2 kubun_2
     * @param shubetsu_1 shubetsu_1
     * @return AtenaSealCreateMybatisParameter
     */
    public static AtenaSealCreateMybatisParameter creatParameter(
            RString chuushutsutaishousha,
            RString chuyshutsukukantxt,
            FlexibleDate chuushutsukikankaishibi,
            FlexibleDate chuushutsukikanshuuryoubi,
            RString shikakukubun,
            RString shichousonshitei,
            RString saiyuusenjyusho,
            RString keishou,
            RString hitemotsubangouhyouji,
            boolean iskatagaki,
            boolean isshichosonmeisho,
            boolean istodofukenmeisho,
            boolean isgunmeisho,
            Long shutsutuokujyunid,
            RString gyoumucode,
            boolean is資格区分_全て,
            boolean is年齢到達日,
            boolean has市町村指定,
            FlexibleDate kankaishibi_第１号,
            FlexibleDate shuuryoubi_第１号,
            FlexibleDate kankaishibi_第２号,
            FlexibleDate shuuryoubi_第２号,
            List<RString> kubun_1,
            List<RString> kubun_2,
            List<RString> shubetsu_1,
            List<RString> shubetsu_2,
            boolean is第1号開始年月日,
            boolean is第2号開始年月日,
            boolean is送付先または代納人,
            boolean is市町村指定,
            boolean is抽出対象者1,
            boolean isDBA業務コード,
            boolean is受給認定申請中を除く,
            RString psmShikibetsuTaisho,
            RString psmAtesaki) {
        return new AtenaSealCreateMybatisParameter(
                chuushutsutaishousha,
                chuyshutsukukantxt,
                chuushutsukikankaishibi,
                chuushutsukikanshuuryoubi,
                shikakukubun,
                shichousonshitei,
                saiyuusenjyusho,
                keishou,
                hitemotsubangouhyouji,
                iskatagaki,
                isshichosonmeisho,
                istodofukenmeisho,
                isgunmeisho,
                shutsutuokujyunid,
                gyoumucode,
                is資格区分_全て,
                is年齢到達日,
                has市町村指定,
                kankaishibi_第１号,
                shuuryoubi_第１号,
                kankaishibi_第２号,
                shuuryoubi_第２号,
                kubun_1,
                kubun_2,
                shubetsu_1,
                shubetsu_2,
                is第1号開始年月日,
                is第2号開始年月日,
                is送付先または代納人,
                is市町村指定,
                is抽出対象者1,
                isDBA業務コード,
                is受給認定申請中を除く,
                psmShikibetsuTaisho,
                psmAtesaki);
    }
}
