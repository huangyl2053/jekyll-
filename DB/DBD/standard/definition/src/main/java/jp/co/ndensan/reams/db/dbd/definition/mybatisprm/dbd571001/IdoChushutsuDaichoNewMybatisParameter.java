/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd571001;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;

/**
 * 受給者台帳のSQLのパラメータクラス
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class IdoChushutsuDaichoNewMybatisParameter implements IMyBatisParameter {

    private final RString 抽出条件設定区分;
    private final HihokenshaNo 被保険者番号From;
    private final HihokenshaNo 被保険者番号To;
    private final RDate 今回抽出開始年月日;
    private final RTime 今回抽出開始時分秒;
    private final RDate 今回抽出終了年月日;
    private final RTime 今回抽出終了時分秒;
    private final List<HihokenshaNo> 被保険者番号リスト;
    private final List<ShikibetsuCode> 識別コードリスト;
    private final RString 出力順;
    private final boolean is広域;
    private final boolean is単一;

    private RDateTime 今回抽出開始日付;
    private RDateTime 今回抽出終了日付;

    /**
     * コンストラクタ
     *
     * @param 抽出条件設定区分 抽出条件設定区分
     * @param 被保険者番号From 被保険者番号From
     * @param 被保険者番号To 被保険者番号To
     * @param 今回抽出開始年月日 今回抽出開始年月日
     * @param 今回抽出開始時分秒 今回抽出開始時分秒
     * @param 今回抽出終了年月日 今回抽出終了年月日
     * @param 今回抽出終了時分秒 今回抽出終了時分秒
     * @param 出力順 出力順
     * @param 被保険者番号リスト 被保険者番号リスト
     * @param 識別コードリスト 識別コードリスト
     * @param is広域 is広域
     * @param is単一 is単一
     */
    public IdoChushutsuDaichoNewMybatisParameter(
            RString 抽出条件設定区分,
            HihokenshaNo 被保険者番号From,
            HihokenshaNo 被保険者番号To,
            RDate 今回抽出開始年月日,
            RTime 今回抽出開始時分秒,
            RDate 今回抽出終了年月日,
            RTime 今回抽出終了時分秒,
            List<HihokenshaNo> 被保険者番号リスト,
            List<ShikibetsuCode> 識別コードリスト,
            RString 出力順,
            boolean is広域,
            boolean is単一) {
        this.抽出条件設定区分 = 抽出条件設定区分;
        this.被保険者番号From = 被保険者番号From;
        this.被保険者番号To = 被保険者番号To;
        this.今回抽出開始年月日 = 今回抽出開始年月日;
        this.今回抽出開始時分秒 = 今回抽出開始時分秒;
        this.今回抽出終了年月日 = 今回抽出終了年月日;
        this.今回抽出終了時分秒 = 今回抽出終了時分秒;
        this.被保険者番号リスト = 被保険者番号リスト;
        this.識別コードリスト = 識別コードリスト;
        this.出力順 = 出力順;
        this.is広域 = is広域;
        this.is単一 = is単一;
        get今回抽出日付();
    }

    private void get今回抽出日付() {
        今回抽出開始日付 = RDateTime.convertFrom(今回抽出開始年月日, 今回抽出開始時分秒);
        今回抽出終了日付 = RDateTime.convertFrom(今回抽出終了年月日, 今回抽出終了時分秒);
    }
}
