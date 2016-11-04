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

    private final RString shichousonshitei;
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
    private final List<RString> 資格区分;
    private final List<RString> 住民種別;
    private final List<RString> 住民状態;
    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;

    /**
     * コンストラクタです。
     *
     * @param shichousonshitei shichousonshitei
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
     * @param 資格区分 資格区分
     * @param 住民種別 住民種別
     * @param 住民状態 住民状態
     * @param is第2号開始年月日 is第2号開始年月日
     * @param psmAtesaki 宛先抽出PSM
     */
    protected AtenaSealCreateMybatisParameter(
            RString shichousonshitei,
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
            List<RString> 資格区分,
            List<RString> 住民種別,
            List<RString> 住民状態,
            RString psmShikibetsuTaisho,
            RString psmAtesaki
    ) {
        this.shichousonshitei = shichousonshitei;
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
        this.資格区分 = 資格区分;
        this.住民種別 = 住民種別;
        this.住民状態 = 住民状態;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
    }

    /**
     * パラメータを作成します。
     *
     * @param shichousonshitei shichousonshitei
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
     * @param 資格区分 資格区分
     * @param 住民種別 住民種別
     * @param 住民状態 住民状態
     * @param kubun_2 kubun_2
     * @param shubetsu_1 shubetsu_1
     * @return AtenaSealCreateMybatisParameter
     */
    public static AtenaSealCreateMybatisParameter creatParameter(
            RString shichousonshitei,
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
            List<RString> 資格区分,
            List<RString> 住民種別,
            List<RString> 住民状態,
            RString psmShikibetsuTaisho,
            RString psmAtesaki) {
        return new AtenaSealCreateMybatisParameter(
                shichousonshitei,
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
                資格区分,
                住民種別,
                住民状態,
                psmShikibetsuTaisho,
                psmAtesaki);
    }
}
