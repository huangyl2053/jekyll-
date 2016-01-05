/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0710011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.koikinaiJushochitokurei.KoikinaiJushochiTokureiBatchParamter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0710011.KoikinaiJushochiTokureiDiv;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * 広域内住所地特例者一覧表Handlerクラスです。
 */
public class KoikinaiJushochiTokureiHandler {

    private static final RString 市町村DDL1件目コード = new RString("000000");
    private static final RString 市町村DDL1件目名称 = new RString("全市町村");
    private static final RString 直近 = new RString("1");
    private static final RString 基準日 = new RString("2");
    private static final RString 範囲 = new RString("3");
    private static final RString 選択 = new RString("key0");
    private static final int 市町村コード = 6;
    private static final int 市町村名称 = 7;

    private final KoikinaiJushochiTokureiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public KoikinaiJushochiTokureiHandler(KoikinaiJushochiTokureiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        SearchResult<KoikiZenShichosonJoho> 市町村List = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho();
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
        div.getBatchParamterInfo().getDdlShichosonShitei().setDataSource(市町村DDL);
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
                // TODO DbzErrorMessages変更なし 
                throw new ApplicationException(DbzErrorMessages.終了日が開始日以前.getMessage());
            }
        }
    }
    
    /**
     * 「実行する」ボタンを押下前のチェック実行します。
     * @return KoikinaiJushochiTokureiBatchParamter
     */
    public KoikinaiJushochiTokureiBatchParamter click実行() {
        KoikinaiJushochiTokureiBatchParamter batchparam = new KoikinaiJushochiTokureiBatchParamter();
        batchparam.setShichosonCode(div.getBatchParamterInfo().getDdlShichosonShitei().getSelectedValue().isEmpty() ? RString.EMPTY : div
                .getBatchParamterInfo().getDdlShichosonShitei().getSelectedValue().substring(0, 市町村コード));
        batchparam.setShichosonName(div.getBatchParamterInfo().getDdlShichosonShitei().getSelectedValue().isEmpty() ? RString.EMPTY : div
                .getBatchParamterInfo().getDdlShichosonShitei().getSelectedValue().substring(市町村名称));
        batchparam.setNarabiId(div.getBatchParamterInfo().getCcdChohyoShutsuryokujun().get出力順ID() == null ? RString.
                EMPTY : new RString(div.getBatchParamterInfo().getCcdChohyoShutsuryokujun().get出力順ID().toString()));
        
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
}
