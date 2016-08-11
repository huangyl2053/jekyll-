/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0120011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakuserviceriyohyomain.KyotakuServiceRiyohyoMainResult;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakuserviceriyohyomain.TaishoshaIchiranResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011.KyotakuServiceRiyohyoMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011.dgKyotakuServiceRirekiIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011.dgRiyoNentstsuIchiran_Row;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakuserviceriyohyomain.KyotakuServiceRiyohyoMainFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.KyotakuservicekeikakuSakuseikubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KyotakuServiceRiyohyoMainDiv}のHandlerクラスです。
 *
 * @reamsid_L DBC-1930-030 huzongcheng
 */
public class KyotakuServiceRiyohyoMainHandler {

    private final KyotakuServiceRiyohyoMainDiv div;

    private static final RString キー_被保険者番号 = new RString("被保険者番号");
    private static final RString キー_対象年月 = new RString("対象年月");
    private static final RString キー_履歴番号 = new RString("履歴番号");

    /**
     * コンストラクタです。
     *
     * @param div KyotakuServiceRiyohyoMainDiv
     */
    public KyotakuServiceRiyohyoMainHandler(KyotakuServiceRiyohyoMainDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div KyotakuServiceRiyohyoMainDiv
     * @return KogakuKaigoKyufuhiTaishoshaTorokuHandler
     */
    public static KyotakuServiceRiyohyoMainHandler of(KyotakuServiceRiyohyoMainDiv div) {
        return new KyotakuServiceRiyohyoMainHandler(div);
    }

    /**
     * 初期化のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void initializeDisplay(HihokenshaNo 被保険者番号) {
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        KyotakuServiceRiyohyoMainFinder finder = KyotakuServiceRiyohyoMainFinder.createInstance();
        List<KyotakuServiceRiyohyoMainResult> resultList
                = finder.selectJyutakukaisyuList(被保険者番号).records();
        setRow(resultList);
    }

    private void setRow(List<KyotakuServiceRiyohyoMainResult> resultList) {
        div.getDgKyotakuServiceRirekiIchiran().init();
        List<dgKyotakuServiceRirekiIchiran_Row> rowList = new ArrayList();
        for (KyotakuServiceRiyohyoMainResult result : resultList) {
            dgKyotakuServiceRirekiIchiran_Row row = new dgKyotakuServiceRirekiIchiran_Row();
            row.getTaishoYM().setValue(new RDate(result.get対象年月().toString()));
            row.setSakuseiKubun(KyotakuservicekeikakuSakuseikubunCode
                    .toValue(result.get作成区分コード()).get名称());
            row.getTekiyoKaishiYMD().setValue(
                    DateConverter.flexibleDateToRDate(result.get適用開始年月日()));
            row.getTekiyoShuryoYMD().setValue(
                    DateConverter.flexibleDateToRDate(result.get適用終了年月日()));
            row.getTodokedeYMD().setValue(
                    DateConverter.flexibleDateToRDate(result.get届出年月日()));
            row.getKoshinYMD().setValue(
                    DateConverter.flexibleDateToRDate(result.get計画変更年月日()));
            row.setMaxRirekiNo(new RString(result.get履歴番号()));
            row.setKyotakuJigyo(result.get居宅_総合事業区分());
            rowList.add(row);
        }
        div.getDgKyotakuServiceRirekiIchiran().setDataSource(rowList);
    }

    /**
     * 居宅サービス履歴一覧の「選択」ボタンのメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 居宅給付計画届出 KyotakuKeikakuTodokede
     */
    public void selectResult(HihokenshaNo 被保険者番号, KyotakuKeikakuTodokede 居宅給付計画届出) {

        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_被保険者番号.toString(), 被保険者番号);
        parameter.put(キー_対象年月.toString(), 居宅給付計画届出.get対象年月());
        parameter.put(キー_履歴番号.toString(), 居宅給付計画届出.get履歴番号());
        KyotakuServiceRiyohyoMainFinder finder = KyotakuServiceRiyohyoMainFinder.createInstance();
        List<TaishoshaIchiranResult> 対象情報一覧 = finder.selectTaishoshaIchiran(parameter).records();
        set自己作成情報エリア(居宅給付計画届出);
        set対象情報一覧(対象情報一覧);

    }

    private void set自己作成情報エリア(KyotakuKeikakuTodokede 居宅給付計画届出) {
        dgKyotakuServiceRirekiIchiran_Row row = div.getDgKyotakuServiceRirekiIchiran().getClickedItem();
        if (居宅給付計画届出.get届出年月日() == null) {
            div.getTxtTodokedeYmd().clearValue();
        } else {
            div.getTxtTodokedeYmd().setValue(DateConverter.flexibleDateToRDate(居宅給付計画届出.get届出年月日()));
        }
        if (居宅給付計画届出.get届出区分() == null) {
            div.getTxtTodokedeKubun().clearValue();
        } else {
            div.getTxtTodokedeKubun().setValue(居宅給付計画届出.get届出区分());
        }
        div.getTxtTekiyoKikan().setFromValue(new RDate(row.getTekiyoKaishiYMD().getValue().toString()));
        if (row.getTekiyoKaishiYMD() == null) {
            div.getTxtTekiyoKikan().clearToValue();
        } else {
            div.getTxtTekiyoKikan().setToValue(new RDate(row.getTekiyoKaishiYMD().getValue().toString()));
        }
        set届出者情報(居宅給付計画届出);
    }

    private void set届出者情報(KyotakuKeikakuTodokede 居宅給付計画届出) {
        if (居宅給付計画届出.get届出者氏名() == null) {
            div.getTodokedesha().getTxtTodokedeshaShimei().clearDomain();
        } else {
            div.getTodokedesha().getTxtTodokedeshaShimei().setDomain(居宅給付計画届出.get届出者氏名());
        }
        if (居宅給付計画届出.get届出者氏名カナ() == null) {
            div.getTodokedesha().getTxtTodokedeshaShimeiKana().clearDomain();
        } else {
            div.getTodokedesha().getTxtTodokedeshaShimeiKana().setDomain(居宅給付計画届出.get届出者氏名カナ());
        }
        if (居宅給付計画届出.get届出者関係区分() == null) {
            div.getTodokedesha().getTxtTodokedeshaKankeiKubun().clearValue();
        } else {
            div.getTodokedesha().getTxtTodokedeshaKankeiKubun().setValue(居宅給付計画届出.get届出者関係区分());
        }
        if (居宅給付計画届出.get届出者電話番号() == null) {
            div.getTodokedesha().getTxtTodokedeshaTelNo().clearDomain();
        } else {
            div.getTodokedesha().getTxtTodokedeshaTelNo().setDomain(居宅給付計画届出.get届出者電話番号());
        }
        if (居宅給付計画届出.get届出者郵便番号() == null) {
            div.getTodokedesha().getTxtYubinNo().clearValue();
        } else {
            div.getTodokedesha().getTxtYubinNo().setValue(居宅給付計画届出.get届出者郵便番号());
        }
        if (居宅給付計画届出.get届出者住所() == null) {
            div.getTodokedesha().getTxtTodokedeshaJusho().clearValue();
        } else {
            div.getTodokedesha().getTxtTodokedeshaJusho().setValue(居宅給付計画届出.get届出者住所());
        }
    }

    private void set対象情報一覧(List<TaishoshaIchiranResult> 対象情報一覧) {
        div.getDgRiyoNentstsuIchiran().init();
        List<dgRiyoNentstsuIchiran_Row> rowList = new ArrayList();
        for (TaishoshaIchiranResult result : 対象情報一覧) {
            dgRiyoNentstsuIchiran_Row row = new dgRiyoNentstsuIchiran_Row();
            row.getRiyoYM().setValue(new RDate(result.get利用年月().toString()));
            row.setKoshinKubun(result.get更新区分());
            row.getKoshinYMD().setValue(DateConverter.flexibleDateToRDate(result.get更新年月日()));
            row.getSofuYM().setValue(result.get送付年月() == null ? null
                    : new RDate(result.get送付年月().toString()));
            rowList.add(row);
        }
        div.getDgRiyoNentstsuIchiran().setDataSource(rowList);
    }

}
