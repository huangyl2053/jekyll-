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
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyotakuServiceRirekiIchiranJoho;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakuserviceriyohyomain.TaishoshaIchiranResult;
import jp.co.ndensan.reams.db.dbc.definition.core.jikosakusei.Kyotaku_SogyoJigyoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.TodokedeshaKankeiKBN;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.KeikakuJigyoshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.KyotakuServiceKeikakuShokaiMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.dgKyotakuServiceRirekiIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.dgRiyoNentstsuIchiran_Row;
import jp.co.ndensan.reams.db.dbc.service.core.jigosakuseimeisaitouroku.JigoSakuseiMeisaiTouroku;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakuserviceriyohyomain.KyotakuServiceRiyohyoMainFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.TodokedeKubun;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
    private static final RString サービス種類_居宅介護 = new RString("居宅介護");
    private static final RString サービス種類_居宅予防 = new RString("居宅予防");
    private static final RString サービス種類_小規模介護 = new RString("小規模介護");
    private static final RString サービス種類_小規模予防 = new RString("小規模予防");
    private static final RString サービス種類_ケアマネジメント = new RString("ケアマネジメント");
    private static final RString 自己作成 = new RString("自己作成");

    /**
     * コンストラクタです。
     *
     * @param div KyotakuServiceKeikakuShokaiMainDiv
     */
    public KyotakuServiceKeikakuShokaiMainHander(KyotakuServiceKeikakuShokaiMainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param 資格対象者 TaishoshaKey
     * @return List<KyotakuServiceRirekiIchiranEntityResult>
     */
    public List<KyotakuServiceRirekiIchiranEntityResult> initialize(TaishoshaKey 資格対象者) {
        div.getCcdKaigoAtenaInfo().initialize(資格対象者.get識別コード());

        if (資格対象者.get被保険者番号() == null || RString.EMPTY.equals(資格対象者.get被保険者番号().getColumnValue())) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace((被保険者番号なし).toString()).evaluate());
        } else {
            div.getCcdKaigoShikakuKihon().initialize(資格対象者.get被保険者番号());
        }
        List<KyotakuServiceRirekiIchiranEntityResult> entityLists
                = JigoSakuseiMeisaiTouroku.createInstance().getKyotakuServiceRirekiIchiran(資格対象者.get被保険者番号());

        List<dgKyotakuServiceRirekiIchiran_Row> rowList = new ArrayList<>();
        dgKyotakuServiceRirekiIchiran_Row row;
        for (KyotakuServiceRirekiIchiranEntityResult entity : entityLists) {
            row = new dgKyotakuServiceRirekiIchiran_Row();
            row.getTaishoYM().setValue(new RDate(entity.getEntity().get対象年月().toDateString().toString()));
            row.getTekiyoKaishiYMD().setValue(DateConverter.flexibleDateToRDate(entity.getEntity().get開始日()));
            row.getTekiyoShuryoYMD().setValue(DateConverter.flexibleDateToRDate((entity.getEntity().get終了日())));
            row.getTodokedeYMD().setValue(DateConverter.flexibleDateToRDate((entity.getEntity().get届出日())));
            row.getKoshinYMD().setValue(entity.getEntity().get更新日() == null
                    ? null : entity.getEntity().get更新日().getDate());
            row.setRirekiNo(new RString(entity.getEntity().get最大履歴番号()));
            row.setSakuseiKubun(JukyushaIF_KeikakuSakuseiKubunCode
                    .toValue(entity.getEntity().get作成区分コード()).get名称());
            row.setKyotakuSogoJigyoKubun(entity.getEntity().get居宅総合事業区分());
            rowList.add(row);

        }
        div.getDgKyotakuServiceRirekiIchiran().setDataSource(rowList);
        ViewStateHolder.put(ViewStateKeys.居宅サービス履歴一覧, new KyotakuServiceRirekiIchiranJoho(entityLists));
        return entityLists;
    }

    /**
     * 対象情報一覧を取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 対象年月
     * @param 作成区分 作成区分
     * @param 居宅給付計画届出 KyotakuKeikakuTodokede
     */
    public void get対象情報一覧(HihokenshaNo 被保険者番号, FlexibleYearMonth 対象年月, RString 作成区分, KyotakuKeikakuTodokede 居宅給付計画届出) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_被保険者番号.toString(), 被保険者番号);
        parameter.put(キー_対象年月.toString(), 居宅給付計画届出.get対象年月());
        parameter.put(キー_履歴番号.toString(), 居宅給付計画届出.get履歴番号());
        KyotakuServiceRiyohyoMainFinder finder = KyotakuServiceRiyohyoMainFinder.createInstance();
        List<TaishoshaIchiranResult> 対象情報一覧 = finder.selectTaishoshaIchiran(parameter).records();
        KyotakuServiceRirekiIchiranEntityResult 居宅サービス履歴 = get居宅サービス履歴(対象年月, 作成区分);
        RString 作成区分コード = 居宅サービス履歴.get作成区分コード();
        set居宅サービス届出情報エリア(居宅給付計画届出, 居宅サービス履歴, 作成区分);
        set対象情報一覧(対象情報一覧, 作成区分コード);
    }

    private KyotakuServiceRirekiIchiranEntityResult get居宅サービス履歴(FlexibleYearMonth 対象年月, RString 作成区分) {
        KyotakuServiceRirekiIchiranJoho ichiranJoho = ViewStateHolder.get(ViewStateKeys.居宅サービス履歴一覧, KyotakuServiceRirekiIchiranJoho.class);
        if (ichiranJoho != null) {
            for (KyotakuServiceRirekiIchiranEntityResult entityResult : ichiranJoho.getRirekiIchiran()) {
                if (対象年月.equals(entityResult.get対象年月())
                        && 作成区分.equals(JukyushaIF_KeikakuSakuseiKubunCode.toValue(entityResult.get作成区分コード()).get名称())) {
                    return entityResult;
                }
            }
        }
        return null;
    }

    private void set居宅サービス届出情報エリア(
            KyotakuKeikakuTodokede 居宅給付計画届出,
            KyotakuServiceRirekiIchiranEntityResult 居宅サービス履歴,
            RString 作成区分) {
        dgKyotakuServiceRirekiIchiran_Row row = div.getDgKyotakuServiceRirekiIchiran().getClickedItem();
        if (居宅給付計画届出.get届出年月日() == null) {
            div.getTxtTodokedeYmd().clearValue();
        } else {
            div.getTxtTodokedeYmd().setValue(DateConverter.flexibleDateToRDate(居宅給付計画届出.get届出年月日()));
        }
        if (RString.isNullOrEmpty(居宅給付計画届出.get届出区分())) {
            div.getTxtTodokedeKubun().clearValue();
        } else {
            div.getTxtTodokedeKubun().setValue(TodokedeKubun.toValue(居宅給付計画届出.get届出区分()).get名称());
        }
        if (row.getTekiyoKaishiYMD() == null || row.getTekiyoKaishiYMD().getValue() == null) {
            div.getTxtTekiyoKikan().clearFromValue();
        } else {
            div.getTxtTekiyoKikan().setFromValue(new RDate(row.getTekiyoKaishiYMD().getValue().toString()));
        }
        if (row.getTekiyoShuryoYMD() == null || row.getTekiyoShuryoYMD().getValue() == null) {
            div.getTxtTekiyoKikan().clearToValue();
        } else {
            div.getTxtTekiyoKikan().setToValue(new RDate(row.getTekiyoShuryoYMD().getValue().toString()));
        }
        div.getTxtKyotakuSogoJigyoKubun().clearValue();
        div.getTxtKeikakuSakuseiKubun().clearValue();

        if (自己作成.equals(作成区分)) {
            div.getTxtKyotakuSogoJigyoKubun().setVisible(true);
            div.getTxtKyotakuSogoJigyoKubun().setValue(居宅サービス履歴.get居宅総合事業区分() != null
                    ? Kyotaku_SogyoJigyoKubun.toValue(居宅サービス履歴.get居宅総合事業区分()).get表示名称() : RString.EMPTY);
        } else {
            div.getTxtKyotakuSogoJigyoKubun().setVisible(false);
        }
        div.getTxtKeikakuSakuseiKubun().setValue(居宅サービス履歴.get作成区分コード() != null
                ? JukyushaIF_KeikakuSakuseiKubunCode.toValue(居宅サービス履歴.get作成区分コード()).get名称() : RString.EMPTY);
        set届出者情報(居宅給付計画届出);
        set計画事業者エリア(居宅サービス履歴);
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
        if (RString.isNullOrEmpty(居宅給付計画届出.get届出者関係区分())) {
            div.getTodokedesha().getTxtTodokedeshaKankeiKubun().clearValue();
        } else {
            div.getTodokedesha().getTxtTodokedeshaKankeiKubun().setValue(
                    TodokedeshaKankeiKBN.toValue(居宅給付計画届出.get届出者関係区分()).get名称());
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

    private void set計画事業者エリア(KyotakuServiceRirekiIchiranEntityResult 居宅サービス履歴) {
        KeikakuJigyoshaDiv jigyoshaDiv = div.getKeikakuJigyosha();
        if (JukyushaIF_KeikakuSakuseiKubunCode.自己作成.getコード().equals(居宅サービス履歴.get作成区分コード())) {
            jigyoshaDiv.setDisplayNone(true);
        } else {
            jigyoshaDiv.setDisplayNone(false);
            jigyoshaDiv.getTxtJigyoshaNo().clearValue();
            jigyoshaDiv.getTxtJigyoshaName().clearValue();
            jigyoshaDiv.getTxtServiceShuruiMeisho().clearValue();
            jigyoshaDiv.getTxtJigyoshaYubinNo().clearValue();
            jigyoshaDiv.getTxtJigyoshaJusho().clearValue();
            jigyoshaDiv.getTxtJigyoshaTelNo().clearDomain();
            jigyoshaDiv.getTxtKanrishaName().clearDomain();
            jigyoshaDiv.getTxtItakusakiJigyoshaNo().clearValue();
            jigyoshaDiv.getTxtItakusakiJigyoshaName().clearValue();
            jigyoshaDiv.getTxtHenkoYMD().clearValue();
            jigyoshaDiv.getTxtHenkoJiyu().clearValue();

            jigyoshaDiv.getTxtJigyoshaNo().setValue(居宅サービス履歴.get事業者番号() != null ? 居宅サービス履歴.get事業者番号() : RString.EMPTY);
            jigyoshaDiv.getTxtJigyoshaName().setValue(居宅サービス履歴.get事業者名() != null ? 居宅サービス履歴.get事業者名() : RString.EMPTY);
            RString サービス種類コード = 居宅サービス履歴.getサービス種類コード().getColumnValue();
            RString サービス種類 = RString.EMPTY;
            if (ServiceCategoryShurui.居宅支援.getコード().equals(サービス種類コード)) {
                サービス種類 = サービス種類_居宅介護;
            } else if (ServiceCategoryShurui.予防支援.getコード().equals(サービス種類コード)) {
                サービス種類 = サービス種類_居宅予防;
            } else if (ServiceCategoryShurui.地小短外.getコード().equals(サービス種類コード)) {
                サービス種類 = サービス種類_小規模介護;
            } else if (ServiceCategoryShurui.地予小外.getコード().equals(サービス種類コード)) {
                サービス種類 = サービス種類_小規模予防;
            } else if (ServiceCategoryShurui.予防ケア.getコード().equals(サービス種類コード)) {
                サービス種類 = サービス種類_ケアマネジメント;
            }
            jigyoshaDiv.getTxtServiceShuruiMeisho().setValue(サービス種類);
            jigyoshaDiv.getTxtJigyoshaYubinNo().setValue(居宅サービス履歴.get事業者郵便番号() != null ? 居宅サービス履歴.get事業者郵便番号()
                    : YubinNo.EMPTY);
            jigyoshaDiv.getTxtJigyoshaJusho().setValue(居宅サービス履歴.get事業者住所() != null ? 居宅サービス履歴.get事業者住所().getColumnValue()
                    : RString.EMPTY);
            jigyoshaDiv.getTxtJigyoshaTelNo().setDomain(居宅サービス履歴.get事業者電話番号() != null ? 居宅サービス履歴.get事業者電話番号() : TelNo.EMPTY);
            jigyoshaDiv.getTxtKanrishaName().setDomain(居宅サービス履歴.get管理者名() != null ? 居宅サービス履歴.get管理者名() : AtenaMeisho.EMPTY);
            jigyoshaDiv.getTxtItakusakiJigyoshaNo().setValue(居宅サービス履歴.get委託先情報者コード() != null ? 居宅サービス履歴.get委託先情報者コード()
                    : RString.EMPTY);
            jigyoshaDiv.getTxtItakusakiJigyoshaName().setValue(居宅サービス履歴.get委託先情報者名() != null ? 居宅サービス履歴.get委託先情報者名()
                    : RString.EMPTY);
            if (居宅サービス履歴.get事業者変更年月日() != null && !居宅サービス履歴.get事業者変更年月日().isEmpty()) {
                jigyoshaDiv.getTxtHenkoYMD().setValue(new RDate(居宅サービス履歴.get事業者変更年月日().toString()));
            }
            jigyoshaDiv.getTxtHenkoJiyu().setValue(居宅サービス履歴.get事業者変更事由() != null ? 居宅サービス履歴.get事業者変更事由() : RString.EMPTY);
        }
    }

    private void set対象情報一覧(List<TaishoshaIchiranResult> 対象情報一覧, RString 作成区分コード) {
        if (JukyushaIF_KeikakuSakuseiKubunCode.自己作成.getコード().equals(作成区分コード)) {
            div.getRiyoNengetsuIchiran().setDisplayNone(false);
            div.getDgRiyoNentstsuIchiran().init();
            List<dgRiyoNentstsuIchiran_Row> rowList = new ArrayList();
            for (TaishoshaIchiranResult result : 対象情報一覧) {
                dgRiyoNentstsuIchiran_Row row = new dgRiyoNentstsuIchiran_Row();
                row.getRiyoYM().setValue(new RDate(result.get利用年月().toString()));
                if (!RString.isNullOrEmpty(result.get更新区分())) {
                    row.setKoshinKubun(KyufukanrihyoSakuseiKubun.toValue(result.get更新区分()).get名称());
                }
                row.getKoshinYMD().setValue(DateConverter.flexibleDateToRDate(result.get更新年月日()));
                row.getSofuYM().setValue(result.get送付年月() == null
                        || RString.EMPTY.equals(result.get送付年月().toDateString()) ? null
                        : new RDate(result.get送付年月().toString()));
                rowList.add(row);
            }
            div.getDgRiyoNentstsuIchiran().setDataSource(rowList);
        } else {
            div.getRiyoNengetsuIchiran().setDisplayNone(true);
        }
    }
}
