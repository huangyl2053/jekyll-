/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0020011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyotakuServiceRirekiIchiranEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakuserviceriyohyomain.TaishoshaIchiranResult;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.KyotakuServiceKeikakuShokaiMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.dgKyotakuServiceRirekiIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.dgRiyoNentstsuIchiran_Row;
import jp.co.ndensan.reams.db.dbc.service.core.jigosakuseimeisaitouroku.JigoSakuseiMeisaiTouroku;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakuserviceriyohyomain.KyotakuServiceRiyohyoMainFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.TodokedeKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.HihokenshaKankeiCode;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBC0020011_居宅サービス計画照会のハンドラクラスです。
 *
 * @reamsid_L DBC-1930-010 xuchangyong
 */
public class KyotakuServiceKeikakuShokaiMainHander {

    private final KyotakuServiceKeikakuShokaiMainDiv div;
    private static final RString 被保険者番号なし = new RString("被保険者番号なし");
    private static final RString キー_被保険者番号 = new RString("被保険者番号");
    private static final RString キー_対象年月 = new RString("対象年月");
    private static final RString キー_履歴番号 = new RString("履歴番号");

    /**
     * コンストラクタです。
     *
     * @param div KyotakuServiceKeikakuShokaiMainDiv
     */
    public KyotakuServiceKeikakuShokaiMainHander(KyotakuServiceKeikakuShokaiMainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param 資格対象者 TaishoshaKey
     */
    public void initialize(TaishoshaKey 資格対象者) {
        div.getCcdKaigoAtenaInfo().initialize(資格対象者.get識別コード());

        if (RString.EMPTY.equals(new RString(資格対象者.get被保険者番号().toString())) || null == 資格対象者.get被保険者番号()) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace((被保険者番号なし).toString()).evaluate());
        } else {
            div.getCcdKaigoShikakuKihon().initialize(資格対象者.get被保険者番号());
        }
        List<KyotakuServiceRirekiIchiranEntityResult> entityLists = JigoSakuseiMeisaiTouroku.createInstance().getKyotakuServiceRirekiIchiran(資格対象者.get被保険者番号());

        List<dgKyotakuServiceRirekiIchiran_Row> rowList = new ArrayList<>();
        dgKyotakuServiceRirekiIchiran_Row row;
        for (KyotakuServiceRirekiIchiranEntityResult entity : entityLists) {
            row = new dgKyotakuServiceRirekiIchiran_Row();
            row.getTaishoYM().setValue(new RDate(entity.getEntity().get対象年月().toDateString().toString()));
            row.getTekiyoKaishiYMD().setValue(new RDate(entity.getEntity().get開始日().toString()));
            row.getTekiyoShuryoYMD().setValue(new RDate(entity.getEntity().get終了日().toString()));
            row.getTodokedeYMD().setValue(new RDate(entity.getEntity().get届出日().toString()));
            row.getKoshinYMD().setValue(new RDate(entity.getEntity().get更新日().getDate().toString()));
            row.setRirekiNo(new RString(entity.getEntity().get最大履歴番号()));
            if (entity.getEntity().get作成区分コード().equals(TodokedeKubun.新規.getコード())) {
                row.setSakuseiKubun(TodokedeKubun.新規.get名称());
            } else if (entity.getEntity().get作成区分コード().equals(TodokedeKubun.変更.getコード())) {
                row.setSakuseiKubun(TodokedeKubun.変更.get名称());
            } else {
                row.setSakuseiKubun(TodokedeKubun.暫定.get名称());
            }
            row.setKyotakuSogoJigyoKubun(entity.getEntity().get居宅総合事業区分());
            rowList.add(row);

        }
        div.getDgKyotakuServiceRirekiIchiran().setDataSource(rowList);
    }

    /**
     * 対象情報一覧を取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 居宅給付計画届出 KyotakuKeikakuTodokede
     */
    public void get対象情報一覧(HihokenshaNo 被保険者番号, KyotakuKeikakuTodokede 居宅給付計画届出) {
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
            div.getTodokedesha().getTxtTodokedeshaKankeiKubun().setValue(
                    HihokenshaKankeiCode.toValue(居宅給付計画届出.get届出者関係区分()).get名称());
        }
        if (居宅給付計画届出.get届出者電話番号() == null) {
            div.getTodokedesha().getTxtTodokedeshaTelNo().clearDomain();
        } else {
            div.getTodokedesha().getTxtTodokedeshaTelNo().setDomain(居宅給付計画届出.get届出者電話番号());
        }
        if (居宅給付計画届出.get届出者郵便番号() == null) {
            div.getTodokedesha().getTxtTodokedeshaYubinNo().clearValue();
        } else {
            div.getTodokedesha().getTxtTodokedeshaYubinNo().setValue(居宅給付計画届出.get届出者郵便番号());
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
            row.setKoshinKubun(KyufukanrihyoSakuseiKubun.toValue(result.get更新区分()).get名称());
            row.getKoshinYMD().setValue(DateConverter.flexibleDateToRDate(result.get更新年月日()));
            row.getSofuYM().setValue(result.get送付年月() == null ? null
                    : new RDate(result.get送付年月().toString()));
            rowList.add(row);
        }
        div.getDgRiyoNentstsuIchiran().setDataSource(rowList);
    }
}
