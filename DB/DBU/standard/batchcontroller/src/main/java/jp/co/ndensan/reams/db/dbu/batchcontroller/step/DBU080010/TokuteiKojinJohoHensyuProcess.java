/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;

/**
 * 版改定の判定のバッチ処理です。
 *
 * @reamsid_L DBU-4880-100 wangxiaodong
 */
public class TokuteiKojinJohoHensyuProcess extends BatchProcessBase<Object> {

//    private static final int 桁目_5 = 4;
//    private static final int 桁目_3 = 2;
//    private static final RString 本番モード = new RString("0");
//    private static final RString テストモード = new RString("1");
//    private static final RDate システム日付 = RDate.getNowDate();
//    private static final RString データ作成日 = getデータ作成日();
//    private TokuteiKojinJohoHensyuProcessParameter processParameter;
//    private RString 行政区コード;
//    private RString 提供機能使用制御;
//    private RString 依頼元部署コード;
//    private RString 特定個人情報分割件数;
//    private RString ログインユーザＩＤ;
//    private RString 連携先団体内統合宛名_連携方式;
//    private RString 電文実行モード;
//    private int 添付データ件数;
//    private int ファイル連番;
//    private int レコード識別番号;
    @Override
    protected void initialize() {
//        添付データ件数 = 0;
//        ファイル連番 = -1;
//        レコード識別番号 = 0;
//        ログインユーザＩＤ = ControlDataHolder.getUserId();
//        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
//        if (DonyuKeitaiCode.事務広域 == DonyuKeitaiCode.toValue(市町村セキュリティ情報.get導入形態コード().value())) {
//            行政区コード = RString.EMPTY;
//        } else {
//            行政区コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value().substring(桁目_3, 桁目_5);
//        }
//        提供機能使用制御 = DbBusinessConfig.get(ConfigNameDBU.番号制度_提供機能使用制御, システム日付, SubGyomuCode.DBU介護統計報告);
//        if (BangoseidoKinoShiyoSeigyo.稼働.getコード().equals(提供機能使用制御)) {
//            電文実行モード = 本番モード;
//        } else {
//            電文実行モード = テストモード;
//        }
//        依頼元部署コード = DbBusinessConfig.get(ConfigNameDBU.番号制度_依頼元部署コード, システム日付, SubGyomuCode.DBU介護統計報告);
//        if (RString.isNullOrEmpty(依頼元部署コード)) {
//            依頼元部署コード = GyomuCode.DB介護保険.value();
//        }
//        特定個人情報分割件数 = DbBusinessConfig.get(ConfigNameDBU.番号制度_特定個人情報分割件数, システム日付, SubGyomuCode.DBU介護統計報告);
//        連携先団体内統合宛名_連携方式 = DbBusinessConfig.get(ConfigNameDBU.番号制度_連携先団体内統合宛名_連携方式, システム日付, SubGyomuCode.DBU介護統計報告);
//        List<TokuteiKojinJohoKoumokuHanKanriBusiness> 項目版管理List = TokuteiKojinJohoTeikyoManager.createInstance()
//                .get項目バージョン(processParameter.get特定個人情報名コード(), processParameter.getデータセット番号(),
//                        processParameter.get版番号(), processParameter.get基準日());
//        for (TokuteiKojinJohoKoumokuHanKanriBusiness business : 項目版管理List) {
//            if (!TokuteiKojinJohoKomokuKubun.繰返し項目.getコード().equals(business.get特定個人情報項目区分())) {
//                項目版管理List.remove(business);
//            }
//        }
    }

    @Override
    protected IBatchReader createReader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void process(Object t) {

    }

//    private static RString getデータ作成日() {
//
//        RStringBuilder builder = new RStringBuilder();
//        builder.append(システム日付.getYearValue());
//        builder.append("-");
//        builder.append(new RString(システム日付.getMonthValue()).padZeroToLeft(2));
//        builder.append("-");
//        builder.append(new RString(システム日付.getDayValue()).padZeroToLeft(2));
//        return builder.toRString();
//    }
}
