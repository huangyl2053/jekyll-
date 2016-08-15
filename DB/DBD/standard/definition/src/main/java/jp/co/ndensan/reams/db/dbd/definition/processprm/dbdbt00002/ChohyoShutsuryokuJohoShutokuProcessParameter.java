/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00002;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt00002.ChohyoShutsuryokuJohoShutokuCsvMybatisprmParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.common.CSVSettings;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力情報の取得_process処理のパラメタークラスです。
 *
 * @reamsid_L DBD-3880-050 x_youyj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChohyoShutsuryokuJohoShutokuProcessParameter implements IBatchProcessParameter {

    // 対象リスト
    private TargetList 対象リスト;
    // 基準日
    private FlexibleDate 基準日;
    // 所得年度
    private RString 所得年度;
    // 旧措置区分
    private KyusochishaKubun 旧措置区分;
    // 世帯表示
    private SetaiHyoji 世帯表示;
    // 受給者区分
    private JukyushaKubun2 受給者区分;
    // 世帯非課税等
    private List<HihokenshaKeizaiJokyo> 世帯非課税等;
    // CSV出力設定
    private CSVSettings 出力設定;
    // 改頁出力順ID
    private Long 改頁出力順ID;
    // 帳票ID
    private RString 帳票ID;

    private RDateTime 帳票作成日時;

    private boolean is認定者リスト = false;
    private boolean is該当者リスト = false;

    private static final RString 一 = new RString("1");
    private static final RString 二 = new RString("2");

    /**
     * 対象者一次特定の引数を返します。
     *
     * @param 対象リスト 対象リスト
     * @param 基準日 基準日
     * @param 所得年度 所得年度
     * @param 旧措置区分 旧措置区分
     * @param 世帯表示 世帯表示
     * @param 受給者区分 受給者区分
     * @param 世帯非課税等 世帯非課税等
     * @param 出力設定 出力設定
     * @param 改頁出力順ID 改頁出力順ID
     * @param 帳票ID 帳票ID
     */
    public ChohyoShutsuryokuJohoShutokuProcessParameter(TargetList 対象リスト,
            FlexibleDate 基準日, RString 所得年度, KyusochishaKubun 旧措置区分, SetaiHyoji 世帯表示,
            JukyushaKubun2 受給者区分, List<HihokenshaKeizaiJokyo> 世帯非課税等, CSVSettings 出力設定,
            Long 改頁出力順ID, RString 帳票ID) {
        this.対象リスト = 対象リスト;
        this.基準日 = 基準日;
        this.所得年度 = 所得年度;
        this.旧措置区分 = 旧措置区分;
        this.世帯表示 = 世帯表示;
        this.受給者区分 = 受給者区分;
        this.世帯非課税等 = 世帯非課税等;
        this.出力設定 = 出力設定;
        this.改頁出力順ID = 改頁出力順ID;
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = RDate.getNowDateTime();
    }

    /**
     * 対象者一次特定の引数を返します。
     *
     * @param 対象リスト 対象リスト
     */
    public ChohyoShutsuryokuJohoShutokuProcessParameter(TargetList 対象リスト) {

        if (一.equals(対象リスト.getコード())) {
            is認定者リスト = true;
        } else if (二.equals(対象リスト.getコード())) {
            is該当者リスト = true;
        }
    }

    /**
     * 利用者負担額減免認定者リスト発行の引数を返します。
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 出力順 出力順
     * @return ChohyoShutsuryokuJohoShutokuCsvMybatisprmParameter
     */
    public ChohyoShutsuryokuJohoShutokuCsvMybatisprmParameter toChohyoShutsuryokuJohoShutokuCsvMybatisprmParameter(
            RString psmShikibetsuTaisho, RString 出力順) {
        return new ChohyoShutsuryokuJohoShutokuCsvMybatisprmParameter(対象リスト, 基準日, 世帯表示, 世帯非課税等, psmShikibetsuTaisho, 出力順);
    }
}
