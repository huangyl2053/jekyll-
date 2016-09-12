/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt00002;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.common.CSVSettings;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力情報の取得のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3880-050 x_youyj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChohyoShutsuryokuJohoShutokuCsvMybatisprmParameter implements IMyBatisParameter {

    private TargetList 対象リスト;
    private FlexibleDate 基準日;
    private RString 所得年度;
    private KyusochishaKubun 旧措置区分;
    private SetaiHyoji 世帯表示;
    private JukyushaKubun2 受給者区分;
    private List<HihokenshaKeizaiJokyo> 世帯非課税等;
    private CSVSettings 出力設定;
    private Long 改頁出力順ID;
    private RString 帳票ID;
    private RDateTime 帳票作成日時;
    private RString 出力順;
    private RString psmShikibetsuTaisho;
    private boolean is認定者リスト = false;
    private boolean is該当者リスト = false;
    private boolean is世帯表示しない = false;
    private static final RString 一 = new RString("1");
    private static final RString 二 = new RString("2");
    private static final RString 三 = new RString("3");
    private static final RString 四 = new RString("4");
    private static final RString 五 = new RString("5");
    private boolean is市町村民税非課税世帯 = false;
    private boolean is所得税非課税世帯 = false;
    private boolean is市町村民税本人非課税者 = false;
    private boolean is老齢福祉年金受給者 = false;
    private boolean is生活保護受給者 = false;

    /**
     * 利用者負担額減免認定者リスト発行の引数を返します。
     *
     * @param 対象リスト 対象リスト
     * @param 基準日 基準日
     * @param 世帯表示 世帯表示
     * @param 世帯非課税等 世帯非課税等
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 出力順 出力順
     */
    public ChohyoShutsuryokuJohoShutokuCsvMybatisprmParameter(
            TargetList 対象リスト, FlexibleDate 基準日, SetaiHyoji 世帯表示,
            List<HihokenshaKeizaiJokyo> 世帯非課税等, RString psmShikibetsuTaisho, RString 出力順) {
        edit対象リスト(対象リスト);
        edit世帯表示(世帯表示);
        edit世帯非課税等(世帯非課税等);
        this.出力順 = 出力順;
        this.基準日 = 基準日;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    private void edit対象リスト(TargetList 対象リスト) {
        if (一.equals(対象リスト.getコード())) {
            is認定者リスト = true;
        } else if (二.equals(対象リスト.getコード())) {
            is該当者リスト = true;
        }
    }

    private void edit世帯表示(SetaiHyoji 世帯表示) {
        if (二.equals(世帯表示.getコード())) {
            is世帯表示しない = true;
        }
    }

    private void edit世帯非課税等(List<HihokenshaKeizaiJokyo> 世帯非課税等) {
        if (null != 世帯非課税等) {
            for (HihokenshaKeizaiJokyo hihokenshaKeizaiJokyo : 世帯非課税等) {
                if (hihokenshaKeizaiJokyo.getコード().contains(一)) {
                    is市町村民税非課税世帯 = true;
                }
                if (hihokenshaKeizaiJokyo.getコード().contains(二)) {
                    is所得税非課税世帯 = true;
                }
                if (hihokenshaKeizaiJokyo.getコード().contains(三)) {
                    is市町村民税本人非課税者 = true;
                }
                if (hihokenshaKeizaiJokyo.getコード().contains(四)) {
                    is老齢福祉年金受給者 = true;
                }
                if (hihokenshaKeizaiJokyo.getコード().contains(五)) {
                    is生活保護受給者 = true;
                }
            }
        }
    }
}
