/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5190001;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者一覧情報の検索のパラメータクラス
 *
 * @reamsid_L DBD-1480-010 zhuxiaojun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public final class NinteiShinseiJohoParameter {

    private final RString shoKisaiHokenshaNo;
    private final boolean logicalDeletedFlag;
    private final RDateTime konkaikaishiTimestamp;
    private final boolean 今回開始;
    private final RDateTime konkaisyuryoTimestamp;
    private final boolean 今回終了;
    private final RString hihokenshaNo;
    private final boolean 被保険者番号入力;
    private final int saidaikensu;
    private final boolean 最大表示件数;

    /**
     * コンストラクタです。
     *
     * @param shoKisaiHokenshaNo RString
     * @param logicalDeletedFlag boolean
     * @param konkaikaishiTimestamp RDateTime
     * @param konkaikaishi boolean
     * @param konkaisyuryoTimestamp RDateTime
     * @param syuryotime boolean
     * @param hihokenshaNo RString
     * @param 被保険者番号入力 boolean
     * @param saidaikensu RString
     * @param 最大表示件数 boolean
     */
    private NinteiShinseiJohoParameter(RString shoKisaiHokenshaNo, boolean logicalDeletedFlag,
            RDateTime konkaikaishiTimestamp, boolean konkaikaishi,
            RDateTime konkaisyuryoTimestamp, boolean syuryotime, RString hihokenshaNo,
            boolean 被保険者番号入力, int saidaikensu, boolean 最大表示件数) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.logicalDeletedFlag = logicalDeletedFlag;
        this.konkaikaishiTimestamp = konkaikaishiTimestamp;
        this.今回開始 = konkaikaishi;
        this.konkaisyuryoTimestamp = konkaisyuryoTimestamp;
        this.今回終了 = syuryotime;
        this.hihokenshaNo = hihokenshaNo;
        this.被保険者番号入力 = 被保険者番号入力;
        this.saidaikensu = saidaikensu;
        this.最大表示件数 = 最大表示件数;
    }

    /**
     * パラメータを生成します。
     *
     * @param shoKisaiHokenshaNo RString
     * @param konkaikaishiTimestamp RString
     * @param konkaisyuryoTimestamp RString
     * @param hihokenshaNo RString
     * @param saidaikensu RString
     * @return NinteiShinseiJohoParameter
     */
    public static NinteiShinseiJohoParameter createSelectByKeyParam(
            RString shoKisaiHokenshaNo,
            RDateTime konkaikaishiTimestamp,
            RDateTime konkaisyuryoTimestamp,
            RString hihokenshaNo,
            RString saidaikensu) {
        boolean logicalDeletedFlag = false;
        boolean 今回開始 = false;
        boolean 今回終了 = false;
        boolean 被保険者番号入力 = false;
        boolean 最大表示件数 = false;
        int saidakensuNo = 0;
        if (!(konkaikaishiTimestamp.toString().isEmpty())) {
            今回開始 = true;
        }
        if (!(konkaikaishiTimestamp.toString().isEmpty())) {
            今回終了 = true;
        }
        if (!RString.isNullOrEmpty(hihokenshaNo)) {
            被保険者番号入力 = true;
        }
        if (!RString.isNullOrEmpty(saidaikensu)) {
            最大表示件数 = true;
            saidakensuNo = Integer.parseInt(saidaikensu.toString());
        }
        return new NinteiShinseiJohoParameter(shoKisaiHokenshaNo, logicalDeletedFlag,
                konkaikaishiTimestamp, 今回開始,
                konkaisyuryoTimestamp, 今回終了, hihokenshaNo,
                被保険者番号入力, saidakensuNo, 最大表示件数);
    }
}
