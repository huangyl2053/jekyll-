/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 境界層管理マスタリストのMyBatisパラメータ
 *
 * @reamsid_L DBU-1050-020 wanghui
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyokaisoGaitoshaMybatisParameter implements IMyBatisParameter {

    private final RString mode;
    private final RString range;
    private final FlexibleDate date_FROM;
    private final FlexibleDate date_TO;
    private final RString iskyuufugakuFlag;
    private final boolean kyuufugakuFlag;
    private final RString ishyojunFutanFlag;
    private final boolean hyojunFutanFlag;
    private final RString iskyojuhinadoFutangFlag;
    private final boolean kyojuhinadoFutangFlag;
    private final RString isshokuhiKeiFlag;
    private final boolean shokuhiKeiFlag;
    private final RString iskogakuFlag;
    private final boolean kogakuFlag;
    private final RString ishokenFlag;
    private final boolean hokenFlag;
    private final RString order_ID;
    private final boolean ismodekjunhe;
    private final boolean ismoderange;
    private final boolean ismodenayi;
    private final boolean isRangeApplication;
    private final boolean isRangeStart;
    private final boolean isRangeEnd;
    private final boolean isDateFlag;
    private final boolean isDate_TOFlag;
    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタ。
     *
     * @param mode 取得モード
     * @param range 境界層対象抽出範囲
     * @param date_FROM 日付FROM
     * @param date_TO 日付TO
     * @param iskyuufugakuFlag 給付額減額解除該当区分フラグ
     * @param kyuufugakuFlag boolean
     * @param ishyojunFutanFlag 標準負担額減額該当区分フラグ
     * @param hyojunFutanFlag boolean
     * @param iskyojuhinadoFutangFlag 特定介護居住費等負担額減額該当区分フラグ
     * @param kyojuhinadoFutangFlag boolean
     * @param isshokuhiKeiFlag 特定介護食費負担額減額該当区分フラグ
     * @param shokuhiKeiFlag boolean
     * @param iskogakuFlag 高額サービス費該当区分フラグ
     * @param kogakuFlag boolean
     * @param ishokenFlag 納付減額該当区分フラグ
     * @param hokenFlag boolean
     * @param order_ID 出力順ID
     * @param ismodekjunhe 基準日
     * @param ismoderange 範囲
     * @param ismodenayi 指定無し
     * @param isRangeApplication 境界層該当申請日
     * @param isRangeStart 境界層該当開始日
     * @param isRangeEnd 境界層該当終了日
     * @param isDateFlag 日付FROMNULL
     * @param isDate_TOFlag 日付ToNULL
     * @param psmShikibetsuTaisho 宛名情報取得
     */
    private KyokaisoGaitoshaMybatisParameter(
            RString mode,
            RString range,
            FlexibleDate date_FROM,
            FlexibleDate date_TO,
            RString iskyuufugakuFlag,
            boolean kyuufugakuFlag,
            RString ishyojunFutanFlag,
            boolean hyojunFutanFlag,
            RString iskyojuhinadoFutangFlag,
            boolean kyojuhinadoFutangFlag,
            RString isshokuhiKeiFlag,
            boolean shokuhiKeiFlag,
            RString iskogakuFlag,
            boolean kogakuFlag,
            RString ishokenFlag,
            boolean hokenFlag,
            RString order_ID,
            boolean ismodekjunhe,
            boolean ismoderange,
            boolean ismodenayi,
            boolean isRangeApplication,
            boolean isRangeStart,
            boolean isRangeEnd,
            boolean isDateFlag,
            boolean isDate_TOFlag,
            RString psmShikibetsuTaisho) {
        this.date_FROM = date_FROM;
        this.date_TO = date_TO;
        this.iskyuufugakuFlag = iskyuufugakuFlag;
        this.range = range;
        this.ishyojunFutanFlag = ishyojunFutanFlag;
        this.iskyojuhinadoFutangFlag = iskyojuhinadoFutangFlag;
        this.isshokuhiKeiFlag = isshokuhiKeiFlag;
        this.iskogakuFlag = iskogakuFlag;
        this.mode = mode;
        this.order_ID = order_ID;
        this.ishokenFlag = ishokenFlag;
        this.ismodekjunhe = ismodekjunhe;
        this.ismoderange = ismoderange;
        this.ismodenayi = ismodenayi;
        this.isRangeApplication = isRangeApplication;
        this.isRangeStart = isRangeStart;
        this.isRangeEnd = isRangeEnd;
        this.isDateFlag = isDateFlag;
        this.isDate_TOFlag = isDate_TOFlag;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.kogakuFlag = kogakuFlag;
        this.kyuufugakuFlag = kyuufugakuFlag;
        this.kyojuhinadoFutangFlag = kyojuhinadoFutangFlag;
        this.shokuhiKeiFlag = shokuhiKeiFlag;
        this.hokenFlag = hokenFlag;
        this.hyojunFutanFlag = hyojunFutanFlag;

    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @param mode 取得モード
     * @param range 境界層対象抽出範囲
     * @param date_FROM 日付FROM
     * @param date_TO 日付TO
     * @param iskyuufugakuFlag 給付額減額解除該当区分フラグ
     * @param ishyojunFutanFlag 標準負担額減額該当区分フラグ
     * @param iskyojuhinadoFutangFlag 特定介護居住費等負担額減額該当区分フラグ
     * @param isshokuhiKeiFlag 特定介護食費負担額減額該当区分フラグ
     * @param iskogakuFlag 高額サービス費該当区分フラグ
     * @param ishokenFlag 納付減額該当区分フラグ
     * @param order_ID 出力順I
     * @param psmShikibetsuTaisho RString
     * @return mybatisパラメータ
     */
    public static KyokaisoGaitoshaMybatisParameter createParam(
            RString mode,
            RString range,
            FlexibleDate date_FROM,
            FlexibleDate date_TO,
            RString iskyuufugakuFlag,
            RString ishyojunFutanFlag,
            RString iskyojuhinadoFutangFlag,
            RString isshokuhiKeiFlag,
            RString iskogakuFlag,
            RString ishokenFlag,
            RString order_ID,
            RString psmShikibetsuTaisho) {
        boolean ismodekjunhe = false;
        boolean hyojunFutanFlag = false;
        boolean kyojuhinadoFutangFlag = false;
        boolean shokuhiKeiFlag = false;
        boolean kogakuFlag = false;
        boolean hokenFlag = false;
        boolean isRangeApplication = false;
        boolean ismoderange = false;
        boolean ismodenayi = false;
        boolean isRangeStart = false;
        boolean isRangeEnd = false;
        boolean isDateFlag = false;
        boolean isDate_TOFlag = false;
        boolean kyuufugakuFlag = false;
        if (new RString("1").equals(mode)) {
            ismodekjunhe = true;
        }
        if (new RString("2").equals(mode)) {
            ismoderange = true;
        }
        if (new RString("3").equals(mode)) {
            ismodenayi = true;
        }
        if (new RString("1").equals(range)) {
            isRangeApplication = true;
        }
        if (new RString("2").equals(range)) {
            isRangeStart = true;
        }
        if (new RString("3").equals(range)) {
            isRangeEnd = true;
        }
        if (date_FROM != null && !date_FROM.isEmpty()) {
            isDateFlag = true;
        }
        if (date_TO != null && !date_TO.isEmpty()) {
            isDate_TOFlag = true;
        }
        if (new RString("1").equals(iskyuufugakuFlag)) {
            kyuufugakuFlag = true;
        }
        if (new RString("1").equals(ishyojunFutanFlag)) {
            hyojunFutanFlag = true;
        }
        if (new RString("1").equals(iskyojuhinadoFutangFlag)) {
            kyojuhinadoFutangFlag = true;
        }
        if (new RString("1").equals(isshokuhiKeiFlag)) {
            shokuhiKeiFlag = true;
        }
        if (new RString("1").equals(iskogakuFlag)) {
            kogakuFlag = true;
        }
        if (new RString("1").equals(ishokenFlag)) {
            hokenFlag = true;
        }
        if (RString.isNullOrEmpty(order_ID)) {
            isDate_TOFlag = true;
        }
        return new KyokaisoGaitoshaMybatisParameter(
                mode,
                range,
                date_FROM,
                date_TO,
                iskyuufugakuFlag,
                kyuufugakuFlag,
                ishyojunFutanFlag,
                hyojunFutanFlag,
                iskyojuhinadoFutangFlag,
                kyojuhinadoFutangFlag,
                isshokuhiKeiFlag,
                shokuhiKeiFlag,
                iskogakuFlag,
                kogakuFlag,
                ishokenFlag,
                hokenFlag,
                order_ID,
                ismodekjunhe,
                ismoderange,
                ismodenayi,
                isRangeApplication,
                isRangeStart,
                isRangeEnd,
                isDateFlag,
                isDate_TOFlag,
                psmShikibetsuTaisho);
    }
}
