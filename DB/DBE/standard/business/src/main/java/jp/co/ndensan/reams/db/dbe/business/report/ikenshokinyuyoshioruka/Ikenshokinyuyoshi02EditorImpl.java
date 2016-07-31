/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshokinyuyoshioruka.Ikenshokinyuyoshi02ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku18;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書（オルカ）のEditorです。
 *
 * @reamsid_L DBE-1600-021 lishengli
 */
public class Ikenshokinyuyoshi02EditorImpl implements IIkenshokinyuyoshi02Editor {

    private static final RString 選択 = new RString("1");
    private static final RString 下線あり = new RString("2");
    private static final RString 下線 = new RString("――――――――――――――――――――――");
    private static final int LENGTH_3 = 3;
    private static final int LENGTH_4 = 4;
    private static final int LENGTH_5 = 5;
    private static final int LENGTH_6 = 6;
    private static final int LENGTH_7 = 7;
    private static final int LENGTH_8 = 8;
    private static final int LENGTH_9 = 9;
    private static final int LENGTH_10 = 10;
    private static final int LENGTH_11 = 11;
    private static final int LENGTH_12 = 12;
    private static final int LENGTH_13 = 13;
    private static final RString チェック = new RString("✔");
    private final IkenshokinyuyoshiBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link IkenshokinyuyoshiBusiness}
     */
    protected Ikenshokinyuyoshi02EditorImpl(IkenshokinyuyoshiBusiness business) {
        this.business = business;
    }

    /**
     * 主治医意見書（オルカ）を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public Ikenshokinyuyoshi02ReportSource edit(Ikenshokinyuyoshi02ReportSource source) {
        return editSource(source);
    }

    private Ikenshokinyuyoshi02ReportSource editSource(Ikenshokinyuyoshi02ReportSource source) {
        if (IkenKomoku08.右.getコード().equals(business.get利き腕())) {
            source.kikiudeRight = チェック;
        } else if (IkenKomoku08.左.getコード().equals(business.get利き腕())) {
            source.kikiudeLeft = チェック;
        }
        source.shincho = business.get身長();
        source.taiju = business.get体重();
        if (IkenKomoku09.増加.getコード().equals(business.get体重の変化())) {
            source.taijuZoka = チェック;
        } else if (IkenKomoku09.維持.getコード().equals(business.get体重の変化())) {
            source.taijuIji = チェック;
        } else if (IkenKomoku09.減少.getコード().equals(business.get体重の変化())) {
            source.taijuGensho = チェック;
        }
        if (IkenKomoku13.チェック有.getコード().equals(business.get四肢欠損())) {
            source.shishikessonUmu = チェック;
        }
        source.shishikesson = business.get四肢欠損部位();
        if (IkenKomoku13.チェック有.getコード().equals(business.get麻痺())) {
            source.mahiUmu = チェック;
        }
        if (IkenKomoku13.チェック有.getコード().equals(business.get麻痺右上肢())) {
            source.mahiMigiueUmu = チェック;
        }
        if (IkenKomoku10.軽.getコード().equals(business.get麻痺右上肢程度())) {
            source.mahiMigiueKei = チェック;
        } else if (IkenKomoku10.中.getコード().equals(business.get麻痺右上肢程度())) {
            source.mahiMigiueChu = チェック;
        } else if (IkenKomoku10.重.getコード().equals(business.get麻痺右上肢程度())) {
            source.mahiMigiueJu = チェック;
        }
        if (IkenKomoku13.チェック有.getコード().equals(business.get麻痺左上肢())) {
            source.mahiHidariueUmu = チェック;
        }
        if (IkenKomoku10.軽.getコード().equals(business.get麻痺左上肢程度())) {
            source.mahiHidariueKei = チェック;
        } else if (IkenKomoku10.中.getコード().equals(business.get麻痺左上肢程度())) {
            source.mahiHidariueChu = チェック;
        } else if (IkenKomoku10.重.getコード().equals(business.get麻痺左上肢程度())) {
            source.mahiHidariueJu = チェック;
        }
        if (IkenKomoku13.チェック有.getコード().equals(business.get麻痺右下肢())) {
            source.mahiMigishitaUmu = チェック;
        }
        return editSource2(source);
    }

    private Ikenshokinyuyoshi02ReportSource editSource2(Ikenshokinyuyoshi02ReportSource source) {
        if (IkenKomoku10.軽.getコード().equals(business.get麻痺右下肢程度())) {
            source.mahiMigishitaKei = チェック;
        } else if (IkenKomoku10.中.getコード().equals(business.get麻痺右下肢程度())) {
            source.mahiMigishitaChu = チェック;
        } else if (IkenKomoku10.重.getコード().equals(business.get麻痺右下肢程度())) {
            source.mahiMigishitaJu = チェック;
        }
        if (IkenKomoku13.チェック有.getコード().equals(business.get麻痺左下肢())) {
            source.mahiHidarishitaUmu = チェック;
        }
        if (IkenKomoku10.軽.getコード().equals(business.get麻痺左下肢程度())) {
            source.mahiHidarishitaKei = チェック;
        } else if (IkenKomoku10.中.getコード().equals(business.get麻痺左下肢程度())) {
            source.mahiHidarishitaChu = チェック;
        } else if (IkenKomoku10.重.getコード().equals(business.get麻痺左下肢程度())) {
            source.mahiHidarishitaJu = チェック;
        }
        if (IkenKomoku13.チェック有.getコード().equals(business.get麻痺その他())) {
            source.mahiSonotaUmu = チェック;
        }
        source.mahiSonotaBui = business.get麻痺その他部位();
        if (IkenKomoku10.軽.getコード().equals(business.get麻痺その他程度())) {
            source.mahiSonotaKei = チェック;
        } else if (IkenKomoku10.中.getコード().equals(business.get麻痺その他程度())) {
            source.mahiSonotaChu = チェック;
        } else if (IkenKomoku10.重.getコード().equals(business.get麻痺その他程度())) {
            source.mahiSonotaJu = チェック;
        }
        if (IkenKomoku13.チェック有.getコード().equals(business.get筋力低下())) {
            source.kinryokuteikaUmu = チェック;
        }
        source.kinryokuteikaBui = business.get筋力低下部位();
        if (IkenKomoku10.軽.getコード().equals(business.get筋力低下程度())) {
            source.kinryokuteikaKei = チェック;
        } else if (IkenKomoku10.中.getコード().equals(business.get筋力低下程度())) {
            source.kinryokuteikaChu = チェック;
        } else if (IkenKomoku10.重.getコード().equals(business.get筋力低下程度())) {
            source.kinryokuteikaJu = チェック;
        }
        if (IkenKomoku13.チェック有.getコード().equals(business.get関節拘縮())) {
            source.kansetsukoshukUmu = チェック;
        }
        source.kansetsukoshukuBui = business.get関節拘縮部位();
        return editSource3(source);
    }

    private Ikenshokinyuyoshi02ReportSource editSource3(Ikenshokinyuyoshi02ReportSource source) {
        if (IkenKomoku10.軽.getコード().equals(business.get関節拘縮程度())) {
            source.kansetsukoshukuKei = チェック;
        } else if (IkenKomoku10.中.getコード().equals(business.get関節拘縮程度())) {
            source.kansetsukoshukuChu = チェック;
        } else if (IkenKomoku10.重.getコード().equals(business.get関節拘縮程度())) {
            source.kansetsukoshukuJu = チェック;
        }
        if (IkenKomoku13.チェック有.getコード().equals(business.get関節痛み())) {
            source.kansetsuitamiUmu = チェック;
        }
        source.kansetsuitamiBui = business.get関節痛み部位();
        if (IkenKomoku10.軽.getコード().equals(business.get関節痛み程度())) {
            source.kansetsuitamiKei = チェック;
        } else if (IkenKomoku10.中.getコード().equals(business.get関節痛み程度())) {
            source.kansetsuitamiChu = チェック;
        } else if (IkenKomoku10.重.getコード().equals(business.get関節痛み程度())) {
            source.kansetsuitamiJu = チェック;
        }
        if (IkenKomoku13.チェック有.getコード().equals(business.get失調不随意運動())) {
            source.shitchoUmu = チェック;
        }
        if (選択.equals(business.get失調不随意運動上肢().substring(0, 1))) {
            source.shitchoJoshiRight = チェック;
        }
        if (選択.equals(business.get失調不随意運動上肢().substring(1))) {
            source.shitchoJoshiLeft = チェック;
        }
        if (選択.equals(business.get失調不随意運動下肢().substring(0, 1))) {
            source.shitchoKashiRight = チェック;
        }
        if (選択.equals(business.get失調不随意運動下肢().substring(1))) {
            source.shitchoKashiLeft = チェック;
        }
        if (選択.equals(business.get体幹().substring(0, 1))) {
            source.shitchoTaikanRight = チェック;
        }
        if (選択.equals(business.get体幹().substring(1))) {
            source.shitchoTaikanLeft = チェック;
        }
        if (IkenKomoku13.チェック有.getコード().equals(business.get褥瘡())) {
            source.jokusoUmu = チェック;
        }
        source.jokusoBui = business.get褥瘡部位();
        if (IkenKomoku10.軽.getコード().equals(business.get褥瘡程度())) {
            source.jokusoKei = チェック;
        } else if (IkenKomoku10.中.getコード().equals(business.get褥瘡程度())) {
            source.jokusoChu = チェック;
        } else if (IkenKomoku10.重.getコード().equals(business.get褥瘡程度())) {
            source.jokusoJu = チェック;
        }
        return editSource4(source);
    }

    private Ikenshokinyuyoshi02ReportSource editSource4(Ikenshokinyuyoshi02ReportSource source) {
        if (IkenKomoku13.チェック有.getコード().equals(business.getその他皮膚疾患())) {
            source.sonotaHifuUmu = チェック;
        }
        source.sonotaHifuBui = business.getその他皮膚疾患部();
        if (IkenKomoku10.軽.getコード().equals(business.getその他皮膚疾程度())) {
            source.sonotaHifuKei = チェック;
        } else if (IkenKomoku10.中.getコード().equals(business.getその他皮膚疾程度())) {
            source.sonotaHifuChu = チェック;
        } else if (IkenKomoku10.重.getコード().equals(business.getその他皮膚疾程度())) {
            source.sonotaHifuJu = チェック;
        }
        if (IkenKomoku11.自立.getコード().equals(business.get屋外歩行())) {
            source.okugaihokoJiritsu = チェック;
        } else if (IkenKomoku11.介助があればしている.getコード().equals(business.get屋外歩行())) {
            source.okugaihokoKaijo = チェック;
        } else if (IkenKomoku11.していない.getコード().equals(business.get屋外歩行())) {
            source.okugaihokoNashi = チェック;
        }
        if (IkenKomoku12.用いていない.getコード().equals(business.get車いすの使用())) {
            source.kurumaisuFushiyo = チェック;
        } else if (IkenKomoku12.主に自分で操作している.getコード().equals(business.get車いすの使用())) {
            source.kurumaisuJiso = チェック;
        } else if (IkenKomoku12.主に他人が操作している.getコード().equals(business.get車いすの使用())) {
            source.kurumaisuTaso = チェック;
        }
        if (選択.equals(business.get歩行補助具_装具の使用().substring(0, 1))) {
            source.hokohojoFushiyo = チェック;
        }
        if (選択.equals(business.get歩行補助具_装具の使用().substring(1, 2))) {
            source.hokohojoOkugai = チェック;
        }
        if (選択.equals(business.get歩行補助具_装具の使用().substring(2))) {
            source.hokohojoOkunai = チェック;
        }
        if (IkenKomoku14.自立ないし何とか自分で食べられる.getコード().equals(business.get食事行為())) {
            source.shokujikoiJiritsu = チェック;
        } else if (IkenKomoku14.全面介助.getコード().equals(business.get食事行為())) {
            source.shokujikoiKaijo = チェック;
        }
        if (IkenKomoku15.良好.getコード().equals(business.get現在の栄養状態())) {
            source.eiyojotaiRyo = チェック;
        } else if (IkenKomoku15.不良.getコード().equals(business.get現在の栄養状態())) {
            source.eiyojotaiFuryo = チェック;
        }
        source.eiyoryuiten = business.get栄養_食生活上の留意点();
        if (選択.equals(business.get発生可能性状態().substring(0, 1))) {
            source.genjoNyoshikkin = チェック;
        }
        return editSource5(source);
    }

    private Ikenshokinyuyoshi02ReportSource editSource5(Ikenshokinyuyoshi02ReportSource source) {
        if (選択.equals(business.get発生可能性状態().substring(1, 2))) {
            source.genjoTento = チェック;
        }
        if (選択.equals(business.get発生可能性状態().substring(2, LENGTH_3))) {
            source.genjoIdoteika = チェック;
        }
        if (選択.equals(business.get発生可能性状態().substring(LENGTH_3, LENGTH_4))) {
            source.genjoJokuso = チェック;
        }
        if (選択.equals(business.get発生可能性状態().substring(LENGTH_4, LENGTH_5))) {
            source.genjoShimpaiteika = チェック;
        }
        if (選択.equals(business.get発生可能性状態().substring(LENGTH_5, LENGTH_6))) {
            source.genjoTojikomori = チェック;
        }
        if (選択.equals(business.get発生可能性状態().substring(LENGTH_6, LENGTH_7))) {
            source.genjoIyokuteika = チェック;
        }
        if (選択.equals(business.get発生可能性状態().substring(LENGTH_7, LENGTH_8))) {
            source.genjoHaikai = チェック;
        }
        if (選択.equals(business.get発生可能性状態().substring(LENGTH_8, LENGTH_9))) {
            source.genjoTeieiyo = チェック;
        }
        if (選択.equals(business.get発生可能性状態().substring(LENGTH_9, LENGTH_10))) {
            source.genjoSesshokuteika = チェック;
        }
        if (選択.equals(business.get発生可能性状態().substring(LENGTH_10, LENGTH_11))) {
            source.genjoDassui = チェック;
        }
        if (選択.equals(business.get発生可能性状態().substring(LENGTH_11, LENGTH_12))) {
            source.genjoIkansen = チェック;
        }
        if (選択.equals(business.get発生可能性状態().substring(LENGTH_12, LENGTH_13))) {
            source.genjoTontsu = チェック;
        }
        if (選択.equals(business.get発生可能性状態().substring(LENGTH_13))) {
            source.genjoSonota = チェック;
        }
        source.genjoSonotaName = business.getその他の状態名();
        source.genjoTaisho = business.get対処方針内容();
        if (IkenKomoku16.期待できる.getコード().equals(business.getサービス利用による生活機能の維持_改善の見通し())) {
            source.seikatsuijiDekiru = チェック;
        } else if (IkenKomoku16.期待できない.getコード().equals(business.getサービス利用による生活機能の維持_改善の見通し())) {
            source.seikatsuijiDekinai = チェック;
        } else if (IkenKomoku16.不明.getコード().equals(business.getサービス利用による生活機能の維持_改善の見通し())) {
            source.seikatsuijiFumei = チェック;
        }
        if (選択.equals(business.get医学的管理の必要性().substring(0, 1))) {
            source.igakukanriShinryo = チェック;
        } else if (下線あり.equals(business.get医学的管理の必要性().substring(0, 1))) {
            source.igakulineShinryo = 下線;
        }
        return editSource6(source);
    }

    private Ikenshokinyuyoshi02ReportSource editSource6(Ikenshokinyuyoshi02ReportSource source) {
        if (選択.equals(business.get医学的管理の必要性().substring(1, 2))) {
            source.igakukanriKango = チェック;
        } else if (下線あり.equals(business.get医学的管理の必要性().substring(1, 2))) {
            source.igakulineKango = 下線;
        }
        if (選択.equals(business.get医学的管理の必要性().substring(2, LENGTH_3))) {
            source.igakukanriShien = チェック;
        } else if (下線あり.equals(business.get医学的管理の必要性().substring(2, LENGTH_3))) {
            source.igakulineShien = 下線;
        }
        if (選択.equals(business.get医学的管理の必要性().substring(LENGTH_3, LENGTH_4))) {
            source.igakukanriShika = チェック;
        } else if (下線あり.equals(business.get医学的管理の必要性().substring(LENGTH_3, LENGTH_4))) {
            source.igakulineShika = 下線;
        }
        if (選択.equals(business.get医学的管理の必要性().substring(LENGTH_4, LENGTH_5))) {
            source.igakukanriYakuzai = チェック;
        } else if (下線あり.equals(business.get医学的管理の必要性().substring(LENGTH_4, LENGTH_5))) {
            source.igakulineYakuzai = 下線;
        }
        if (選択.equals(business.get医学的管理の必要性().substring(LENGTH_5, LENGTH_6))) {
            source.igakukanriHomonriha = チェック;
        } else if (下線あり.equals(business.get医学的管理の必要性().substring(LENGTH_5, LENGTH_6))) {
            source.igakulineHomonriha = 下線;
        }
        if (選択.equals(business.get医学的管理の必要性().substring(LENGTH_6, LENGTH_7))) {
            source.igakukanriNyusho = チェック;
        } else if (下線あり.equals(business.get医学的管理の必要性().substring(LENGTH_6, LENGTH_7))) {
            source.igakulineNyusho = 下線;
        }
        if (選択.equals(business.get医学的管理の必要性().substring(LENGTH_7, LENGTH_8))) {
            source.igakukanriShikaeisei = チェック;
        } else if (下線あり.equals(business.get医学的管理の必要性().substring(LENGTH_7, LENGTH_8))) {
            source.igakulineShikaeisei = 下線;
        }
        if (選択.equals(business.get医学的管理の必要性().substring(LENGTH_8, LENGTH_9))) {
            source.igakukanriEiyo = チェック;
        } else if (下線あり.equals(business.get医学的管理の必要性().substring(LENGTH_8, LENGTH_9))) {
            source.igakulineEiyo = 下線;
        }
        if (選択.equals(business.get医学的管理の必要性().substring(LENGTH_9, LENGTH_10))) {
            source.igakukanriTsushoriha = チェック;
        } else if (下線あり.equals(business.get医学的管理の必要性().substring(LENGTH_9, LENGTH_10))) {
            source.igakulineTsushoriha = 下線;
        }
        return editSource7(source);
    }

    private Ikenshokinyuyoshi02ReportSource editSource7(Ikenshokinyuyoshi02ReportSource source) {
        if (選択.equals(business.get医学的管理の必要性().substring(LENGTH_10, LENGTH_11))) {
            source.igakukanriSonota = チェック;
        } else if (下線あり.equals(business.get医学的管理の必要性().substring(LENGTH_10, LENGTH_11))) {
            source.igakulineSonota = 下線;
        }
        source.igakukanriSonotaName = business.getその他の医学的管理();
        if (IkenKomoku17.特になし.getコード().equals(business.getサービス提供血圧())) {
            source.ryuiKetsuatsuNashi = チェック;
        } else if (IkenKomoku17.あり.getコード().equals(business.getサービス提供血圧())) {
            source.ryuiKetsuatsuAri = チェック;
        }
        source.ryuijikoKetsuatsu = business.getサービス提供血圧留意事項();
        if (IkenKomoku17.特になし.getコード().equals(business.getサービス提供摂食())) {
            source.ryuiSesshokuNashi = チェック;
        } else if (IkenKomoku17.あり.getコード().equals(business.getサービス提供摂食())) {
            source.ryuiSesshokuAri = チェック;
        }
        source.ryuijikoSesshoku = business.getサービス提供摂食留意事項();
        if (IkenKomoku17.特になし.getコード().equals(business.getサービス提供嚥下())) {
            source.ryuiEngeNashi = チェック;
        } else if (IkenKomoku17.あり.getコード().equals(business.getサービス提供嚥下())) {
            source.ryuiEngeAri = チェック;
        }
        source.ryuijikoEnge = business.getサービス提供嚥下留意事項();
        if (IkenKomoku17.特になし.getコード().equals(business.getサービス提供移動())) {
            source.ryuiIdoNashi = チェック;
        } else if (IkenKomoku17.あり.getコード().equals(business.getサービス提供移動())) {
            source.ryuiIdoAri = チェック;
        }
        source.ryuijikoIdo = business.getサービス提供移動留意事項();
        if (IkenKomoku17.特になし.getコード().equals(business.getサービス提供運動())) {
            source.ryuiUndoNashi = チェック;
        } else if (IkenKomoku17.あり.getコード().equals(business.getサービス提供運動())) {
            source.ryuiUndoAri = チェック;
        }
        source.ryuijikoUndo = business.getサービス提供運動留意事項();
        source.ryuijikoSonota = business.getサービス提供その他の留意事項();
        if (IkenKomoku18.無.getコード().equals(business.get感染症有無())) {
            source.kansenshoNashi = チェック;
        } else if (IkenKomoku18.有.getコード().equals(business.get感染症有無())) {
            source.kansenshoAri = チェック;
        } else if (IkenKomoku18.不明.getコード().equals(business.get感染症有無())) {
            source.kansenshoFumei = チェック;
        }
        source.kansenshoName = business.get感染症名();
        source.sonoTatokki = business.getその他特記事項();
        return source;
    }

    //TODO 改行コード(CRLF)を垂直タブ(VT)で置き換え（先頭から11個まで）その他特記事項は700文字／12行以内の処理対応待ち。
//    private RString getその他特記事項() {
//        List<RString> list = business.getその他特記事項().split("\r\n");
//        RStringBuilder その他特記事項 = new RStringBuilder();
//        if (0 < list.size()) {
//            その他特記事項.append(list.get(0)).append(System.lineSeparator());
//        }
//        if (1 < list.size()) {
//            if (その他特記事項.length() <= LENGTH_700) {
//                その他特記事項 = その他特記事項.append(list.get(1)).append(System.lineSeparator());
//            } else {
//                return その他特記事項.substring(0, LENGTH_700);
//            }
//        }
//        if (2 > list.size()) {
//            if (その他特記事項.length() <= LENGTH_700) {
//                その他特記事項 = その他特記事項.append(list.get(2)).append(System.lineSeparator());
//            } else {
//                return その他特記事項.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_3 < list.size()) {
//            if (その他特記事項.length() <= LENGTH_700) {
//                その他特記事項 = その他特記事項.append(list.get(LENGTH_3)).append(System.lineSeparator());
//            } else {
//                return その他特記事項.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_4 < list.size()) {
//            if (その他特記事項.length() <= LENGTH_700) {
//                その他特記事項 = その他特記事項.append(list.get(LENGTH_4)).append(System.lineSeparator());
//            } else {
//                return その他特記事項.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_5 < list.size()) {
//            if (その他特記事項.length() <= LENGTH_700) {
//                その他特記事項 = その他特記事項.append(list.get(LENGTH_5)).append(System.lineSeparator());
//            } else {
//                return その他特記事項.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_6 < list.size()) {
//            if (その他特記事項.length() <= LENGTH_700) {
//                その他特記事項 = その他特記事項.append(list.get(LENGTH_6)).append(System.lineSeparator());
//            } else {
//                return その他特記事項.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_7 < list.size()) {
//            if (その他特記事項.length() <= LENGTH_700) {
//                その他特記事項 = その他特記事項.append(list.get(LENGTH_7)).append(System.lineSeparator());
//            } else {
//                return その他特記事項.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_8 < list.size()) {
//            if (その他特記事項.length() <= LENGTH_700) {
//                その他特記事項 = その他特記事項.append(list.get(LENGTH_8)).append(System.lineSeparator());
//            } else {
//                return その他特記事項.substring(0, LENGTH_700);
//            }
//        }
//        return getその他特記事項(その他特記事項, list);
//    }
//
//    private RString getその他特記事項(RStringBuilder その他特記事項, List<RString> list) {
//        if (LENGTH_9 < list.size()) {
//            if (その他特記事項.length() <= LENGTH_700) {
//                その他特記事項 = その他特記事項.append(list.get(LENGTH_9)).append(System.lineSeparator());
//            } else {
//                return その他特記事項.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_10 < list.size()) {
//            if (その他特記事項.length() <= LENGTH_700) {
//                その他特記事項 = その他特記事項.append(list.get(LENGTH_10)).append(System.lineSeparator());
//            } else {
//                return その他特記事項.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_11 < list.size()) {
//            if (その他特記事項.length() <= LENGTH_700) {
//                その他特記事項 = その他特記事項.append(list.get(LENGTH_11)).append(System.lineSeparator());
//            } else {
//                return その他特記事項.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_700 <= その他特記事項.length()) {
//            return その他特記事項.substring(0, LENGTH_700);
//        }
//        return その他特記事項.toRString();
//    }
}
