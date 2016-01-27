/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.idochecklist;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動チェックリストのパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoCheckListGetDataParameter implements IMyBatisParameter {

    private RDateTime konkaiKaishi;
    private RDateTime konkaiShuryo;
    private RString daichoShubetsu;
    private ShikibetsuCode shikibetsuCode;
    private GyomuCode gyomuCode;
    private FlexibleDate jukyuKaishiYMD;
    private RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     *
     * @param konkaiKaishi 今回開始日時
     * @param konkaiShuryo 今回終了日時
     * @param daichoShubetsu 台帳種別
     * @param shikibetsuCode 識別コード
     * @param gyomuCode 業務コード
     * @param jukyuKaishiYMD 受給開始日
     * @param psmShikibetsuTaisho 宛名識別対象
     */
    private IdoCheckListGetDataParameter(
            RDateTime konkaiKaishi,
            RDateTime konkaiShuryo,
            RString daichoShubetsu,
            ShikibetsuCode shikibetsuCode,
            GyomuCode gyomuCode,
            FlexibleDate jukyuKaishiYMD,
            RString psmShikibetsuTaisho) {
        this.konkaiKaishi = konkaiKaishi;
        this.konkaiShuryo = konkaiShuryo;
        this.daichoShubetsu = daichoShubetsu;
        this.shikibetsuCode = shikibetsuCode;
        this.gyomuCode = gyomuCode;
        this.jukyuKaishiYMD = jukyuKaishiYMD;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param konkaiKaishi 今回開始日時
     * @param konkaiShuryo 今回終了日時
     * @param daichoShubetsu 台帳種別
     * @param shikibetsuCode 識別コード
     * @param gyomuCode 業務コード
     * @param jukyuKaishiYMD 受給開始日
     * @return IdoCheckListGetDataParameter
     */
    public static IdoCheckListGetDataParameter createIdoCheckListGetDataParameter(
            RDateTime konkaiKaishi,
            RDateTime konkaiShuryo,
            RString daichoShubetsu,
            ShikibetsuCode shikibetsuCode,
            GyomuCode gyomuCode,
            FlexibleDate jukyuKaishiYMD) {
        return new IdoCheckListGetDataParameter(konkaiKaishi, konkaiShuryo, daichoShubetsu, shikibetsuCode, gyomuCode, jukyuKaishiYMD, RString.EMPTY);
    }

    /**
     * 宛名識別対象検索用のパラメータを生成します。
     *
     * @param psmShikibetsuTaisho 宛名識別対象
     * @return IdoCheckListGetDataParameter
     */
    public static IdoCheckListGetDataParameter createShikibetsuTaishoPsmParameter(
            RString psmShikibetsuTaisho) {
        return new IdoCheckListGetDataParameter(
                null, null, RString.EMPTY, null, null, null,
                psmShikibetsuTaisho);
    }
}
