/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0710011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU050010.DBU050010_KoikinaiJushochitokureishaIchiranhyoParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0710011.KoikinaiJushochiTokureiDiv;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * 広域内住所地特例者一覧表Handlerクラスです。
 *
 * @reamsid_L DBU-1140-030 dongyabin
 */
public class KoikinaiJushochiTokureiHandler {

    private static final RString 市町村DDL1件目コード = new RString("000000");
    private static final RString 市町村DDL1件目名称 = new RString("全市町村");
    private static final RString 直近 = new RString("1");
    private static final RString 基準日 = new RString("2");
    private static final RString 範囲 = new RString("3");
    private static final int 市町村コード = 6;
    private static final int 市町村名称 = 7;

    private final KoikinaiJushochiTokureiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KoikinaiJushochiTokurei のクラスファイル
     */
    public KoikinaiJushochiTokureiHandler(KoikinaiJushochiTokureiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 市町村List 広域全市町村
     */
    public void onLoad(SearchResult<KoikiZenShichosonJoho> 市町村List) {
        List<KeyValueDataSource> 市町村DDL = new ArrayList<>();
        RStringBuilder 一件目名称 = new RStringBuilder();
        一件目名称.append(市町村DDL1件目コード);
        一件目名称.append(RString.HALF_SPACE);
        一件目名称.append(市町村DDL1件目名称);
        市町村DDL.add(new KeyValueDataSource(市町村DDL1件目コード, 一件目名称.toRString()));
        for (int i = 0; i < 市町村List.records().size(); i++) {
            RStringBuilder 二件目名称 = new RStringBuilder();
            二件目名称.append(市町村List.records().get(i).get市町村コード().getColumnValue());
            二件目名称.append(RString.HALF_SPACE);
            二件目名称.append(市町村List.records().get(i).get市町村名称());
            市町村DDL.add(new KeyValueDataSource(new RString(String.valueOf(i + 1)), 二件目名称.toRString()));
        }
        Collections.sort(市町村DDL, new ComparatorByStartDateSort());
        div.getBatchParamterInfo().getDdlShichosonShitei().setDataSource(市町村DDL);
        div.getBatchParamterInfo().getDdlShichosonShitei().setSelectedKey(市町村DDL1件目コード);
        div.getBatchParamterInfo().getTxtKijunYMD().setDisabled(true);
        div.getBatchParamterInfo().getTxtKonkaiKaishibi().setDisabled(true);
        div.getBatchParamterInfo().getTxtKonkaiShuryobi().setDisabled(true);
    }

    /**
     * 「直近」ラジオボタンを選択します。
     */
    public void clickRadChokin() {
        div.getBatchParamterInfo().getTxtKijunYMD().setDisabled(true);
        div.getBatchParamterInfo().getTxtKonkaiKaishibi().setDisabled(true);
        div.getBatchParamterInfo().getTxtKonkaiShuryobi().setDisabled(true);
    }

    /**
     * 「基準日」ラジオボタンを選択します。
     */
    public void clickRadKijyunbi() {
        div.getBatchParamterInfo().getTxtKijunYMD().setDisabled(false);
        div.getBatchParamterInfo().getTxtKonkaiKaishibi().setDisabled(true);
        div.getBatchParamterInfo().getTxtKonkaiShuryobi().setDisabled(true);
    }

    /**
     * 「範囲」ラジオボタンを選択します。
     */
    public void clickRadHani() {
        div.getBatchParamterInfo().getTxtKijunYMD().setDisabled(true);
        div.getBatchParamterInfo().getTxtKonkaiKaishibi().setDisabled(false);
        div.getBatchParamterInfo().getTxtKonkaiShuryobi().setDisabled(false);
    }

    /**
     * 「実行する」ボタンを押下前のチェック実行します。
     */
    public void is入力チェック() {
        if (!div.getBatchParamterInfo().getRadKijyunbi().getSelectedKey().isEmpty()
                && div.getBatchParamterInfo().getTxtKijunYMD().getValue().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace("基準日"));
        } else if (!div.getBatchParamterInfo().getRadHani().getSelectedKey().isEmpty()) {
            if (div.getBatchParamterInfo().getTxtKonkaiKaishibi().getValue().isEmpty()
                    && div.getBatchParamterInfo().getTxtKonkaiShuryobi().getValue().isEmpty()) {
                throw new ApplicationException(UrErrorMessages.必須項目_追加メッセージあり.getMessage().
                        replace("今回開始日と今回終了日のいずれか１つ以上を入力してください。"));
            }
            if (div.getBatchParamterInfo().getTxtKonkaiShuryobi().getValue().isBefore(div
                    .getBatchParamterInfo().getTxtKonkaiKaishibi().getValue())) {
                throw new ApplicationException(DbzErrorMessages.期間が不正_未来日付不可.getMessage()
                        .replace("今回開始日", "今回終了日"));
            }
        }
    }

    /**
     * 「実行する」ボタンを押下バッチ実行、バッチパラメータ作成をします。
     *
     * @return DBU050010_KoikinaiJushochitokureishaIchiranhyoParameter 広域内住所地特例者一覧表_バッチパラメータクラスです
     */
    public DBU050010_KoikinaiJushochitokureishaIchiranhyoParameter click実行() {
        DBU050010_KoikinaiJushochitokureishaIchiranhyoParameter batchparam = new DBU050010_KoikinaiJushochitokureishaIchiranhyoParameter();
        batchparam.setShichosonCode(div.getBatchParamterInfo().getDdlShichosonShitei().getSelectedValue().isEmpty() ? RString.EMPTY : div
                .getBatchParamterInfo().getDdlShichosonShitei().getSelectedValue().substring(0, 市町村コード));
        batchparam.setShichosonName(div.getBatchParamterInfo().getDdlShichosonShitei().getSelectedValue().isEmpty() ? RString.EMPTY : div
                .getBatchParamterInfo().getDdlShichosonShitei().getSelectedValue().substring(市町村名称));
        batchparam.setNarabiId(div.getBatchParamterInfo().getCcdChohyoShutsuryokujun().get出力順ID() == null ? RString.EMPTY : new RString(div.getBatchParamterInfo().getCcdChohyoShutsuryokujun().get出力順ID().toString()));

        if (!div.getBatchParamterInfo().getRadChokin().getSelectedKey().isEmpty()) {
            batchparam.setModel(直近);
            batchparam.setKijyunbi(null);
            batchparam.setKaishibi(null);
            batchparam.setShuryobi(null);
        } else if (!div.getBatchParamterInfo().getRadKijyunbi().getSelectedKey().isEmpty()) {
            batchparam.setModel(基準日);
            batchparam.setKijyunbi(new RString(div.getBatchParamterInfo().getTxtKijunYMD().getValue().toString()));
            batchparam.setKaishibi(null);
            batchparam.setShuryobi(null);
        } else if (!div.getBatchParamterInfo().getRadHani().getSelectedKey().isEmpty()) {
            batchparam.setModel(範囲);
            batchparam.setKijyunbi(null);
            batchparam.setKaishibi(new RString(div.getBatchParamterInfo().getTxtKonkaiKaishibi().getValue().toString()));
            batchparam.setShuryobi(new RString(div.getBatchParamterInfo().getTxtKonkaiShuryobi().getValue().toString()));
        }
        return batchparam;
    }

    private static class ComparatorByStartDateSort implements Comparator {

        @Override
        public int compare(Object arg0, Object arg1) {
            KeyValueDataSource row0 = (KeyValueDataSource) arg0;
            KeyValueDataSource row1 = (KeyValueDataSource) arg1;
            return row0.getValue().compareTo(row1.getValue());
        }
    }
}
