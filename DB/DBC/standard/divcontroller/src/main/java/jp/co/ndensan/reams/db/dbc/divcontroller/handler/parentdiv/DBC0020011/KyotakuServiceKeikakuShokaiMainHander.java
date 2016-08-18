/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0020011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyotakuServiceRirekiIchiranEntityResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.KyotakuServiceKeikakuShokaiMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.dgKyotakuServiceRirekiIchiran_Row;
import jp.co.ndensan.reams.db.dbc.service.core.jigosakuseimeisaitouroku.JigoSakuseiMeisaiTouroku;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.KyotakuservicekeikakuSakuseikubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.TodokedeKubun;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
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
    private TaishoshaKey 資格対象者 = null;

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
     */
    public void initialize() {
        資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        div.getCcdKaigoAtenaInfo().initialize(資格対象者.get識別コード());

        if (RString.EMPTY.equals(new RString(資格対象者.get被保険者番号().toString())) || null == 資格対象者.get被保険者番号()) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace((被保険者番号なし).toString()).evaluate());
        } else {
            div.getCcdKaigoShikakuKihon().initialize(資格対象者.get被保険者番号());
        }
        List<KyotakuServiceRirekiIchiranEntityResult> entityLists = JigoSakuseiMeisaiTouroku.createInstance().getKyotakuServiceRirekiIchiran(資格対象者.get被保険者番号());

        List<dgKyotakuServiceRirekiIchiran_Row> rowList = new ArrayList<>();
        dgKyotakuServiceRirekiIchiran_Row row;
        if (entityLists.isEmpty()) {
            div.getDgKyotakuServiceRirekiIchiran().setDataSource(rowList);
        } else {
            for (KyotakuServiceRirekiIchiranEntityResult entity : entityLists) {
                row = new dgKyotakuServiceRirekiIchiran_Row();
                row.getTaishoYM().setValue(new RDate(entity.getEntity().get対象年月().toDateString().toString()));
                if (entity.getEntity().get作成区分コード().equals(KyotakuservicekeikakuSakuseikubunCode.指定居宅介護支援事業者作成.getコード())) {
                    row.setTodokedeKubun(KyotakuservicekeikakuSakuseikubunCode.指定居宅介護支援事業者作成.get名称());
                } else if (entity.getEntity().get作成区分コード().equals(KyotakuservicekeikakuSakuseikubunCode.基準該当居宅介護支援事業者作成.getコード())) {
                    row.setTodokedeKubun(KyotakuservicekeikakuSakuseikubunCode.基準該当居宅介護支援事業者作成.get名称());
                } else if (entity.getEntity().get作成区分コード().equals(KyotakuservicekeikakuSakuseikubunCode.自己作成.getコード())) {
                    row.setTodokedeKubun(KyotakuservicekeikakuSakuseikubunCode.自己作成.get名称());
                } else {
                    row.setTodokedeKubun(KyotakuservicekeikakuSakuseikubunCode.介護予防支援事業者作成.get名称());
                }
                row.setKeikakuJigyoshaNo(entity.getEntity().get事業者番号());
                row.setJgsJigyoshaName(entity.getEntity().get事業者名());
                row.setItakusakiJigyoshaNo(entity.getEntity().get委託先情報者コード());
                row.setItkjgsJigyoshaName(entity.getEntity().get委託先情報者名());
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
                row.setTodokedeshaShimei(entity.getEntity().get氏名());
                row.setTodokedeshaShimeiKana(entity.getEntity().getカナ());
                row.setTodokedeshaKankeiKubun(entity.getEntity().get関係区分());
                row.setTodokedeshaTelNo(entity.getEntity().get電話番号());
                row.setTodokedeshaYubinNo(entity.getEntity().get郵便番号());
                row.setTodokedeshaJusho(entity.getEntity().get住所());
                rowList.add(row);
            }
            div.getDgKyotakuServiceRirekiIchiran().setDataSource(rowList);
        }
    }

    /**
     * 2.対象情報一覧を取得
     */
    public void get対象情報一覧() {
        資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        dgKyotakuServiceRirekiIchiran_Row rirekiIchiranRow = this.div.getDgKyotakuServiceRirekiIchiran().getClickedItem();

        div.getTxtTodokedeYmd().setValue(new RDate(rirekiIchiranRow.getTodokedeYMD().getValue().toString()));
        div.getTxtTodokedeKubun().setValue(rirekiIchiranRow.getTodokedeKubun());
        div.getTxtTekiyoKikan().setFromValue(new RDate(rirekiIchiranRow.getTekiyoKaishiYMD().getValue().toString()));
        div.getTxtTekiyoKikan().setToValue(new RDate(rirekiIchiranRow.getTekiyoShuryoYMD().getValue().toString()));
//        div.getTodokedesha().getTxtTodokedeshaShimei().setDomain(new AtenaMeisho(rirekiIchiranRow.getTodokedeshaShimei()));
//        div.getTodokedesha().getTxtTodokedeshaShimeiKana().setDomain(new AtenaKanaMeisho(rirekiIchiranRow.getTodokedeshaShimeiKana()));
//        if (rirekiIchiranRow.getTodokedeshaKankeiKubun().equals(HihokenshaKankeiCode.審査請求人.getコード())) {
//            div.getTodokedesha().getTxtTodokedeshaKankeiKubun().setValue(HihokenshaKankeiCode.審査請求人.get名称());
//        } else if (rirekiIchiranRow.getTodokedeshaKankeiKubun().equals(HihokenshaKankeiCode.代理人.getコード())) {
//            div.getTodokedesha().getTxtTodokedeshaKankeiKubun().setValue(HihokenshaKankeiCode.代理人.get名称());
//        } else {
//            div.getTodokedesha().getTxtTodokedeshaKankeiKubun().setValue(HihokenshaKankeiCode.総代.get名称());
//        }
//        div.getTodokedesha().getTxtTodokedeshaTelNo().setDomain(new TelNo(rirekiIchiranRow.getTodokedeshaTelNo()));
//        div.getTodokedesha().getTxtTodokedeshaYubinNo().setValue(new YubinNo(rirekiIchiranRow.getTodokedeshaYubinNo()));
//        div.getTodokedesha().getTxtTodokedeshaJusho().setValue(rirekiIchiranRow.getTodokedeshaJusho());

//        FlexibleYearMonth 対象年月 = new FlexibleYearMonth(rirekiIchiranRow.getTaishoYM().getValue().getYearMonth().toString());
//        int 履歴番号 = (new Integer(rirekiIchiranRow.getRirekiNoMax().toString())).intValue();
//        List<RiyoNentstsuIchiranEntityResult> entityList = JigoSakuseiMeisaiTouroku.createInstance().getRiyoNentstsuIchiran(資格対象者.get被保険者番号(), 対象年月, 履歴番号);
//        dgRiyoNentstsuIchiran_Row row;
//        List<dgRiyoNentstsuIchiran_Row> stsuIchiranRowList = new ArrayList<>();
//        if (entityList.isEmpty()) {
//            div.getDgRiyoNentstsuIchiran().setDataSource(stsuIchiranRowList);
//        } else {
//            for (RiyoNentstsuIchiranEntityResult entity : entityList) {
//                row = new dgRiyoNentstsuIchiran_Row();
//                row.getRiyoYM().setValue(new RDate(entity.getEntity().get利用年月().toDateString().toString()));
//                if (KyufukanrihyoSakuseiKubun.新規.getコード().equals(entity.getEntity().get更新区分())) {
//                    row.setKoshinKubun(KyufukanrihyoSakuseiKubun.新規.get名称());
//                } else if (KyufukanrihyoSakuseiKubun.変更.getコード().equals(entity.getEntity().get更新区分())) {
//                    row.setKoshinKubun(KyufukanrihyoSakuseiKubun.変更.get名称());
//                } else {
//                    row.setKoshinKubun(KyufukanrihyoSakuseiKubun.新規.get名称());
//                }
//                row.getKoshinYMD().setValue(new RDate(entity.getEntity().get更新年月日().toString()));
//                row.getSofuYM().setValue(new RDate(entity.getEntity().get送付年月().toDateString().toString()));
//                row.setKyotakuSogoJigyoKubun(rirekiIchiranRow.getKyotakuSogoJigyoKubun());
//                row.getTaishoYM().setValue(rirekiIchiranRow.getTaishoYM().getValue());
//                row.setRirekiNo(rirekiIchiranRow.getRirekiNoMax());
//                stsuIchiranRowList.add(row);
//            }
//            div.getDgRiyoNentstsuIchiran().setDataSource(stsuIchiranRowList);
//        }
    }

    /**
     * 3.サービス利用票を取得
     */
    public void getサービス利用票() {
//        dgRiyoNentstsuIchiran_Row row = this.div.getDgRiyoNentstsuIchiran().getClickedItem();
//        RString 居宅総合事業区分 = row.getKyotakuSogoJigyoKubun();
//        照会
//        資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        FlexibleYearMonth 対象年月 = new FlexibleYearMonth(row.getTaishoYM().getValue().getYearMonth().toString());
//        int 履歴番号 = (new Integer(row.getRirekiNo().toString())).intValue();
//        FlexibleYearMonth 利用年月 = new FlexibleYearMonth(row.getRiyoYM().getValue().getYearMonth().toString());
//        div.getCcdServiceRiyohyoInfo().initialize(居宅総合事業区分, 照会, 資格対象者.get被保険者番号(), 対象年月, 履歴番号, 利用年月);
    }

}
