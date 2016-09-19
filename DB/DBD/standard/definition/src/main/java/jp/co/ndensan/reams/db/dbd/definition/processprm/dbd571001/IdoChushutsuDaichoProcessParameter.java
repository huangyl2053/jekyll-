/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd571001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd571001.IdoChushutsuDaichoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd571001.IdoChushutsuDaichoNewMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者台帳のProcess用パラメータクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class IdoChushutsuDaichoProcessParameter implements IBatchProcessParameter {

    private RString 抽出条件設定区分;
    private HihokenshaNo 被保険者番号From;
    private HihokenshaNo 被保険者番号To;
    private RDate 今回抽出開始年月日;
    private RTime 今回抽出開始時分秒;
    private RDate 今回抽出終了年月日;
    private RTime 今回抽出終了時分秒;
    private List<RString> 異動抽出対象リスト;
    private RString 出力オプション区分;
    private RString 出力順設定リスト;
    private RString 市町村コード;

    /**
     * コンストラクタです。
     *
     * @param 抽出条件設定区分 抽出条件設定区分
     * @param 被保険者番号From 被保険者番号From
     * @param 被保険者番号To 被保険者番号To
     * @param 今回抽出開始年月日 今回抽出開始年月日
     * @param 今回抽出開始時分秒 今回抽出開始時分秒
     * @param 今回抽出終了年月日 今回抽出終了年月日
     * @param 今回抽出終了時分秒 今回抽出終了時分秒
     * @param 異動抽出対象リスト 異動抽出対象リスト
     * @param 出力オプション区分 出力オプション区分
     * @param 出力順設定リスト 出力順設定リスト
     * @param 市町村コード 市町村コード
     */
    public IdoChushutsuDaichoProcessParameter(
            RString 抽出条件設定区分,
            HihokenshaNo 被保険者番号From,
            HihokenshaNo 被保険者番号To,
            RDate 今回抽出開始年月日,
            RTime 今回抽出開始時分秒,
            RDate 今回抽出終了年月日,
            RTime 今回抽出終了時分秒,
            List<RString> 異動抽出対象リスト,
            RString 出力オプション区分,
            RString 出力順設定リスト,
            RString 市町村コード) {
        this.抽出条件設定区分 = 抽出条件設定区分;
        this.被保険者番号From = 被保険者番号From;
        this.被保険者番号To = 被保険者番号To;
        this.今回抽出開始年月日 = 今回抽出開始年月日;
        this.今回抽出開始時分秒 = 今回抽出開始時分秒;
        this.今回抽出終了年月日 = 今回抽出終了年月日;
        this.今回抽出終了時分秒 = 今回抽出終了時分秒;
        this.異動抽出対象リスト = 異動抽出対象リスト;
        this.出力オプション区分 = 出力オプション区分;
        this.出力順設定リスト = 出力順設定リスト;
        this.市町村コード = 市町村コード;
    }

    public IdoChushutsuDaichoMybatisParameter toIdoChushutsuDaichoMybatisParameter() {
        return new IdoChushutsuDaichoMybatisParameter(
                抽出条件設定区分,
                被保険者番号From,
                被保険者番号To,
                今回抽出開始年月日,
                今回抽出開始時分秒,
                今回抽出終了年月日,
                今回抽出終了時分秒,
                異動抽出対象リスト,
                出力オプション区分,
                出力順設定リスト,
                市町村コード);
    }

    public IdoChushutsuDaichoNewMybatisParameter toIdoChushutsuDaichoNewMybatisParameter(
            List<HihokenshaNo> 被保険者番号リスト,
            List<ShikibetsuCode> 識別コードリスト,
            boolean is広域,
            boolean is単一) {
        return new IdoChushutsuDaichoNewMybatisParameter(
                抽出条件設定区分,
                被保険者番号From,
                被保険者番号To,
                今回抽出開始年月日,
                今回抽出開始時分秒,
                今回抽出終了年月日,
                今回抽出終了時分秒,
                被保険者番号リスト,
                識別コードリスト,
                出力順設定リスト,
                is広域,
                is単一);
    }
}
