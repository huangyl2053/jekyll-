/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.tankinyushokakudaigaitosha;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.tankinyushokakudaigaitosha.ChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.tankinyushokakudaigaitosha.GendogakuKanriKikansu;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_短期入所拡大該当者のMybatis用パラメータクラスです。
 *
 * @reamsid_L DBC-3111-020 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TankiNyushoKakudaiGaitoshaMybatisParameter implements IMyBatisParameter {

    private final RString 保険者コード;
    private final boolean is保険者コード;
    private final RString 抽出区分;
    private final boolean is抽出区分_直近;
    private final RString 適用開始年月From;
    private final boolean is適用開始年月FromNULL;
    private final RString 適用開始年月To;
    private final boolean is適用開始年月ToNULL;
    private final RString 適用終了年月From;
    private final boolean is適用終了年月FromNULL;
    private final RString 適用終了年月To;
    private final boolean is適用終了年月ToNULL;
    private final RString 限度額管理期間数;
    private final boolean is入力済みを含む;
    private final RString psmShikibetsuTaisho;
    private final RString 出力順;

    /**
     * コンストラクタです。
     */
    private TankiNyushoKakudaiGaitoshaMybatisParameter(
            RString 保険者コード,
            boolean is保険者コード,
            RString 抽出区分,
            boolean is抽出区分_直近,
            RString 適用開始年月From,
            boolean is適用開始年月FromNULL,
            RString 適用開始年月To,
            boolean is適用開始年月ToNULL,
            RString 適用終了年月From,
            boolean is適用終了年月FromNULL,
            RString 適用終了年月To,
            boolean is適用終了年月ToNULL,
            RString 限度額管理期間数,
            boolean is入力済みを含む,
            RString psmShikibetsuTaisho,
            RString 出力順) {
        this.保険者コード = 保険者コード;
        this.is保険者コード = is保険者コード;
        this.抽出区分 = 抽出区分;
        this.is抽出区分_直近 = is抽出区分_直近;
        this.適用開始年月From = 適用開始年月From;
        this.is適用開始年月FromNULL = is適用開始年月FromNULL;
        this.適用開始年月To = 適用開始年月To;
        this.is適用開始年月ToNULL = is適用開始年月ToNULL;
        this.適用終了年月From = 適用終了年月From;
        this.is適用終了年月FromNULL = is適用終了年月FromNULL;
        this.適用終了年月To = 適用終了年月To;
        this.is適用終了年月ToNULL = is適用終了年月ToNULL;
        this.限度額管理期間数 = 限度額管理期間数;
        this.is入力済みを含む = is入力済みを含む;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.出力順 = 出力順;
    }

    /**
     * MybatisParameterの作成です。
     *
     * @param 保険者コード 保険者コード
     * @param 抽出区分 抽出区分
     * @param 適用開始年月From 適用開始年月From
     * @param 適用開始年月To 適用開始年月To
     * @param 適用終了年月From 適用終了年月From
     * @param 適用終了年月To 適用終了年月To
     * @param 限度額管理期間数 限度額管理期間数
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 出力順 出力順
     * @return KijunShunyugakuTekiyoMybatisParameter
     */
    public static TankiNyushoKakudaiGaitoshaMybatisParameter createMybatisParameter(RString 保険者コード,
            RString 抽出区分,
            RString 適用開始年月From,
            RString 適用開始年月To,
            RString 適用終了年月From,
            RString 適用終了年月To,
            RString 限度額管理期間数,
            RString psmShikibetsuTaisho,
            RString 出力順) {
        boolean is保険者コード = false;
        boolean is抽出区分_直近 = false;
        boolean is入力済みを含む = false;
        if (!RString.isNullOrEmpty(保険者コード) && !new RString("000000").equals(保険者コード)) {
            is保険者コード = true;
        }

        if (ChushutsuKubun.最新拡大データ.getコード().equals(抽出区分)) {
            is抽出区分_直近 = true;
        }
        if (GendogakuKanriKikansu.入力済みを含まない.getコード().equals(限度額管理期間数)) {
            is入力済みを含む = true;
        }
        return new TankiNyushoKakudaiGaitoshaMybatisParameter(保険者コード,
                is保険者コード,
                抽出区分,
                is抽出区分_直近,
                適用開始年月From,
                isnull(適用開始年月From),
                適用開始年月To,
                isnull(適用開始年月To),
                適用終了年月From,
                isnull(適用終了年月From),
                適用終了年月To,
                isnull(適用終了年月To),
                限度額管理期間数,
                is入力済みを含む,
                psmShikibetsuTaisho,
                出力順);
    }

    private static boolean isnull(RString value) {
        boolean flag = false;
        if (RString.isNullOrEmpty(value)) {
            flag = true;
        }
        return flag;
    }
}
