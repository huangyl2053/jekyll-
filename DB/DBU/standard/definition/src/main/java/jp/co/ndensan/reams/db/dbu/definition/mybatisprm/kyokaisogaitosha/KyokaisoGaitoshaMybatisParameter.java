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
import lombok.Setter;

/**
 *
 * 境界層管理マスタリストのMyBatisパラメータ
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KyokaisoGaitoshaMybatisParameter implements IMyBatisParameter {

    private final RString mode;
    private final RString Range;
    private final FlexibleDate Date_FROM;
    private final FlexibleDate Date_TO;
    private final RString iskyuufugakuGengakuKisaiKiajoFlag;
    private final RString ishyojunFutanGengakuGaitoFlag;
    private final RString iskyojuhinadoFutangakugengakuGaitoFlag;
    private final RString isshokuhiKeigengoHutangakuGaitoFlag;
    private final RString iskogakuServicehiJogengakuGengakuGaitoFlag;
    private final RString ishokenryoNofuGengakuFlag;
    private final RString order_ID;
    private final boolean ismodeFlag1;
    private final boolean ismodeFlag2;
    private final boolean ismodeFlag3;
    private final boolean isRangeFlag1;
    private final boolean isRangeFlag2;
    private final boolean isRangeFlag3;
    private final boolean isDateFlag;
    private final boolean isDate_TOFlag;
    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタ
     *
     * @param mode 取得モード
     * @param Range 境界層対象抽出範囲
     * @param Date_FROM 日付FROM
     * @param Date_TO 日付TO
     * @param iskyuufugakuGengakuKisaiKiajoFlag
     * @param ishyojunFutanGengakuGaitoFlag
     * @param iskyojuhinadoFutangakugengakuGaitoFlag
     * @param isshokuhiKeigengoHutangakuGaitoFlag
     * @param iskogakuServicehiJogengakuGengakuGaitoFlag
     * @param ishokenryoNofuGengakuFlag
     * @param order_ID 出力順ID
     * @param ismodeFlag1
     * @param psmShikibetsuTaisho
     * @param ismodeFlag2
     * @param isDate_TOFlag
     * @param ismodeFlag3
     * @param isDateFlag
     * @param isRangeFlag1
     * @param isRangeFlag3
     * @param isRangeFlag2
     */
    public KyokaisoGaitoshaMybatisParameter(RString mode,
            RString Range,
            FlexibleDate Date_FROM,
            FlexibleDate Date_TO,
            RString iskyuufugakuGengakuKisaiKiajoFlag,
            RString ishyojunFutanGengakuGaitoFlag,
            RString iskyojuhinadoFutangakugengakuGaitoFlag,
            RString isshokuhiKeigengoHutangakuGaitoFlag,
            RString iskogakuServicehiJogengakuGengakuGaitoFlag,
            RString ishokenryoNofuGengakuFlag,
            RString order_ID,
            boolean ismodeFlag1,
            boolean ismodeFlag2,
            boolean ismodeFlag3,
            boolean isRangeFlag1,
            boolean isRangeFlag2,
            boolean isRangeFlag3,
            boolean isDateFlag,
            boolean isDate_TOFlag,
            RString psmShikibetsuTaisho) {
        this.Date_FROM = Date_FROM;
        this.Date_TO = Date_TO;
        this.iskyuufugakuGengakuKisaiKiajoFlag = iskyuufugakuGengakuKisaiKiajoFlag;
        this.Range = Range;
        this.ishokenryoNofuGengakuFlag = ishokenryoNofuGengakuFlag;
        this.ishyojunFutanGengakuGaitoFlag = ishyojunFutanGengakuGaitoFlag;
        this.iskyojuhinadoFutangakugengakuGaitoFlag = iskyojuhinadoFutangakugengakuGaitoFlag;
        this.isshokuhiKeigengoHutangakuGaitoFlag = isshokuhiKeigengoHutangakuGaitoFlag;
        this.mode = mode;
        this.order_ID = order_ID;
        this.iskogakuServicehiJogengakuGengakuGaitoFlag = iskogakuServicehiJogengakuGengakuGaitoFlag;
        this.ismodeFlag1 = ismodeFlag1;
        this.ismodeFlag2 = ismodeFlag2;
        this.ismodeFlag3 = ismodeFlag3;
        this.isRangeFlag1 = isRangeFlag1;
        this.isRangeFlag2 = isRangeFlag2;
        this.isRangeFlag3 = isRangeFlag3;
        this.isDateFlag = isDateFlag;
        this.isDate_TOFlag = isDate_TOFlag;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    public static KyokaisoGaitoshaMybatisParameter createParam(RString mode,
            RString Range,
            FlexibleDate Date_FROM,
            FlexibleDate Date_TO,
            RString iskyuufugakuGengakuKisaiKiajoFlag,
            RString ishyojunFutanGengakuGaitoFlag,
            RString iskyojuhinadoFutangakugengakuGaitoFlag,
            RString isshokuhiKeigengoHutangakuGaitoFlag,
            RString iskogakuServicehiJogengakuGengakuGaitoFlag,
            RString ishokenryoNofuGengakuFlag,
            RString order_ID,
            boolean ismodeFlag1,
            boolean ismodeFlag2,
            boolean ismodeFlag3,
            boolean isRangeFlag1,
            boolean isRangeFlag2,
            boolean isRangeFlag3,
            boolean isDateFlag,
            boolean isDate_TOFlag,
            RString psmShikibetsuTaisho) {

        if (new RString("1").equals(mode)) {
            ismodeFlag1 = true;
        }
        if (new RString("2").equals(mode)) {
            ismodeFlag2 = true;
        }
        if (new RString("3").equals(mode)) {
            ismodeFlag1 = true;
        }
        if (new RString("1").equals(Range)) {
            isRangeFlag1 = true;
        }
        if (new RString("2").equals(Range)) {
            isRangeFlag2 = true;
        }
        if (new RString("3").equals(Range)) {
            isRangeFlag3 = true;
        }
        if (Date_FROM == null || Date_FROM.isEmpty()) {
            isDateFlag = true;
        }
        if (Date_TO == null || Date_TO.isEmpty()) {
            isDate_TOFlag = true;
        }
        return new KyokaisoGaitoshaMybatisParameter(mode,
                Range,
                Date_FROM,
                Date_TO,
                iskyuufugakuGengakuKisaiKiajoFlag,
                ishyojunFutanGengakuGaitoFlag,
                iskyojuhinadoFutangakugengakuGaitoFlag,
                ishokenryoNofuGengakuFlag,
                isshokuhiKeigengoHutangakuGaitoFlag,
                iskogakuServicehiJogengakuGengakuGaitoFlag,
                order_ID,
                ismodeFlag1,
                ismodeFlag2,
                ismodeFlag3,
                isRangeFlag1,
                isRangeFlag2,
                isRangeFlag3,
                isDateFlag,
                isDate_TOFlag,
                psmShikibetsuTaisho);

    }
}
