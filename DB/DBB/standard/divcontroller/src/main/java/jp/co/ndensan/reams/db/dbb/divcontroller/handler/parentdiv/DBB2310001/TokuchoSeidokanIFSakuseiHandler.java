/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2310001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.tokuchosedokaniftanichu.TokuchoSedokanIFTanichuResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2310001.TokuchoSeidokanIFSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchosedokaniftanichu.TokuchoSedokanIFTanichu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 画面設計_DBBGM84001_2_特徴制度間Ｉ／Ｆ（単一他社）
 *
 * @reamsid_L DBB-1830-010 yangchenbing
 */
public class TokuchoSeidokanIFSakuseiHandler {

    private static final RString MESSAGE_特徴対象者同定が終了しない = new RString("特徴対象者同定が終了しない");
    private static final RString MESSAGE_特徴制度間F処理 = new RString("特徴制度間I/F処理");
    private static final RString 年度内連番_0001 = new RString("0001");
    private static final RString 年度内連番_0002 = new RString("0002");
    private static final RString 年度内連番_0003 = new RString("0003");
    private static final RString 年度内連番_0004 = new RString("0004");
    private static final RString 年度内連番_0005 = new RString("0005");
    private static final RString 年度内連番_0006 = new RString("0006");
    private static final RString 未処理 = new RString("未処理");
    private static final RString 処理済 = new RString("処理済");
    private static final RString KEY = new RString("key");
    private static final RString KEY0 = new RString("key0");
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM4 = 4;
    private static final int NUM6 = 6;
    private static final int NUM8 = 8;
    private static final int NUM10 = 10;
    private static final int NUM12 = 12;
    private final TokuchoSedokanIFTanichu tokuchosedokaniftanichu;
    private final TokuchoSeidokanIFSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TokuchoSeidokanIFSakuseiDiv
     */
    public TokuchoSeidokanIFSakuseiHandler(TokuchoSeidokanIFSakuseiDiv div) {
        tokuchosedokaniftanichu = new TokuchoSedokanIFTanichu();
        this.div = div;
    }

    /**
     * 所得情報アップロードの画面初期化処理するメソッドです。
     *
     */
    public void initialize() {
        List<TokuchoSedokanIFTanichuResult> results = tokuchosedokaniftanichu.getTokuchoKaishiYMList();
        List<KeyValueDataSource> dataSourceList = new ArrayList();
        FlexibleYear 年度 = FlexibleYear.MIN;
        if (results.isEmpty()) {
            throw new ApplicationException(DbzErrorMessages.実行不可.getMessage().
                    replace(MESSAGE_特徴対象者同定が終了しない.toString(), MESSAGE_特徴制度間F処理.toString()));
        }
        Collections.sort(results, new Comparator<TokuchoSedokanIFTanichuResult>() {

            @Override
            public int compare(TokuchoSedokanIFTanichuResult result1, TokuchoSedokanIFTanichuResult result2) {
                return result2.get特徴開始年月().compareTo(result1.get特徴開始年月());
            }
        });
        int i = NUM0;
        for (TokuchoSedokanIFTanichuResult result : results) {
            if (result.get特徴開始年月() != null) {
                if (i == 0) {
                    年度 = result.get年度();
                }
                KeyValueDataSource datasource = new KeyValueDataSource();
                datasource.setKey(KEY.concat(new RString(i)));
                datasource.setValue(result.get特徴開始年月().getYearMonth().wareki().toDateString());
                dataSourceList.add(datasource);
                i = i + NUM1;
            }
        }
        div.getDdlKaishiYM().setDataSource(dataSourceList);
        div.getDdlKaishiYM().setSelectedKey(KEY0);
        if (!FlexibleYear.MIN.equals(年度)) {
            div.getTxtChoteiNendo().setValue(new RDate(年度.toString()));
        }
        onChange_特別徴収開始年月();
    }

    /**
     * onChange_特別徴収開始年月の方法です。
     */
    public void onChange_特別徴収開始年月() {
        RString 選択値 = div.getDdlKaishiYM().getSelectedValue();
        RDate 特別徴収開始年月 = new RDate(選択値.toString());
        int 選択値の月 = 特別徴収開始年月.getMonthValue();
        RString 年度内連番;
        switch (選択値の月) {
            case NUM8:
                年度内連番 = 年度内連番_0001;
                break;
            case NUM10:
                年度内連番 = 年度内連番_0002;
                break;
            case NUM12:
                年度内連番 = 年度内連番_0003;
                break;
            case NUM2:
                年度内連番 = 年度内連番_0004;
                break;
            case NUM4:
                年度内連番 = 年度内連番_0005;
                break;
            case NUM6:
                年度内連番 = 年度内連番_0006;
                break;
            default:
                年度内連番 = RString.EMPTY;
        }
        FlexibleYear 処理年度 = new FlexibleYear(特別徴収開始年月.getYear().toDateString());
        List<ShoriDateKanri> shoridatekanriList = tokuchosedokaniftanichu.getSyoriKanrenJoho(処理年度, 年度内連番);
        if (shoridatekanriList == null || shoridatekanriList.isEmpty() || shoridatekanriList.get(0).get基準日時() == null
                || shoridatekanriList.get(0).get基準日時().isEmpty()) {
            div.getTxtShoriJotai().setValue(未処理);
            div.getTxtZenKaiShoriYMD().clearValue();
            div.getTxtZenKaiShoriYMD().setPlaceHolder(RString.EMPTY);
            div.getTxtZenKaiShoriTime().clearValue();
            div.getTxtZenKaiShoriTime().setPlaceHolder(RString.EMPTY);
        } else {
            div.getTxtShoriJotai().setValue(処理済);
            YMDHMS 基準日時 = shoridatekanriList.get(NUM0).get基準日時();
            if (基準日時 != null) {
                div.getTxtZenKaiShoriYMD().setValue(基準日時.getDate());
                div.getTxtZenKaiShoriTime().setValue(new RTime(new RString(基準日時.toString().substring(NUM8))));
            }
        }
    }

    /**
     * batchparameterを作成します。
     *
     * @param div TokuchoSeidokanIFSakuseiDiv
     * @return param TokuchoSeidokanIFSakuseiBatchParameter
     */
    public TokuchoSeidokanIFSakuseiBatchParameter getbatchparam(TokuchoSeidokanIFSakuseiDiv div) {
        TokuchoSedokanIFTanichuResult result = new TokuchoSedokanIFTanichuResult();
        result.set年度(new FlexibleYear(div.getTxtChoteiNendo().getValue().toString().substring(NUM0, NUM4)));
        result.set特徴開始年月(new RDate(div.getDdlKaishiYM().getSelectedValue().toString()));
        result.set遷移元メニュー(ResponseHolder.getMenuID());
        return tokuchosedokaniftanichu.getBatchiPara(result);
    }
}
