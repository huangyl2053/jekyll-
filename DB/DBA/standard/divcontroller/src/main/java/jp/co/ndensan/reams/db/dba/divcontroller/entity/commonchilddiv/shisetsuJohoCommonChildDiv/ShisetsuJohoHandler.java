package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shisetsuJohoCommonChildDiv1111111;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shisetujyoho.KaigoJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.business.core.shisetujyoho.KaigoJogaiTokureiTaishoShisetsuInputGuide;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.shisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dba.service.core.shisetsu.ShisetsuJohoInputGuideFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 施設情報のHandlerクラスです。
 */
public class ShisetsuJohoHandler {

    private final shisetsuJohoCommonChildDivDiv div;
    private static final RString 台帳種別表示有り = new RString("台帳種別表示有り");
    private static final RString 台帳種別表示無し = new RString("台帳種別表示無し");
    private static final RString 被保険者 = new RString("被保険者");
    private static final RString 他市町村住所地特例者 = new RString("他市町村住所地特例者");
    private static final RString 適用除外者 = new RString("適用除外者");

    /**
     * コンストラクタです。
     *
     * @param div ShisetsuJohoCommonChildDivDiv
     */
    public ShisetsuJohoHandler(shisetsuJohoCommonChildDivDiv div) {
        this.div = div;
    }

    /**
     * 施設情報に初期化を設定する。
     *
     */
    public void load() {

        if (台帳種別表示有り.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示有り, RString.class))) {

            div.getDdlDaichoShubetsu().setDataSource(ドロップダウンの設定());
            div.getDdlDaichoShubetsu().setSelectedKey(DaichoType.被保険者.getCode());
            div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getCode());
        }

        if (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示無し, RString.class))
                && !被保険者.equals(ViewStateHolder.get(ViewStateKeys.被保険者, RString.class))
                && !他市町村住所地特例者.equals(ViewStateHolder.get(ViewStateKeys.他市町村住所地特例者, RString.class))
                && !適用除外者.equals(ViewStateHolder.get(ViewStateKeys.適用除外者, RString.class))) {

            div.getRadKaigoHokenShisetsu().setVisible(true);
            div.getRadOtherTokureiShisetsu().setVisible(true);
            div.getRadTekiyoJyogaiShisetsu().setVisible(true);
            div.getDdlDaichoShubetsu().setVisible(false);
            div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getCode());
        }

        if (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示無し, RString.class))) {
            if (被保険者.equals(ViewStateHolder.get(ViewStateKeys.被保険者, RString.class))) {
                div.getRadTekiyoJyogaiShisetsu().setVisible(false);
                div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getCode());
                div.getDdlDaichoShubetsu().setVisible(false);
            }

            if (他市町村住所地特例者.equals(ViewStateHolder.get(ViewStateKeys.他市町村住所地特例者, RString.class))) {

                div.getRadTekiyoJyogaiShisetsu().setVisible(false);
                div.getDdlDaichoShubetsu().setVisible(false);
                div.getRadOtherTokureiShisetsu().setSelectedKey(ShisetsuType.住所地特例対象施設.getCode());
            }
            if (適用除外者.equals(ViewStateHolder.get(ViewStateKeys.適用除外者, RString.class))) {

                div.getRadKaigoHokenShisetsu().setVisible(false);
                div.getRadOtherTokureiShisetsu().setVisible(false);
                div.getRadTekiyoJyogaiShisetsu().setVisible(false);
                div.getDdlDaichoShubetsu().setVisible(false);
            }
        }
    }

    /**
     * 台帳種別を設定する。
     *
     */
    public void onChange() {

        if (DaichoType.被保険者.getCode().equals(div.getDdlDaichoShubetsu().getSelectedKey())) {
            div.getRadKaigoHokenShisetsu().setVisible(true);
            div.getRadOtherTokureiShisetsu().setVisible(true);
            div.getRadTekiyoJyogaiShisetsu().setVisible(false);
            div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getCode());
        }

        if (DaichoType.他市町村住所地特例者.getCode().equals(div.getDdlDaichoShubetsu().getSelectedKey())) {
            div.getRadKaigoHokenShisetsu().setVisible(true);
            div.getRadOtherTokureiShisetsu().setVisible(true);
            div.getRadTekiyoJyogaiShisetsu().setVisible(false);
            div.getRadOtherTokureiShisetsu().setSelectedKey(ShisetsuType.住所地特例対象施設.getCode());
        }

        if (DaichoType.適用除外者.getCode().equals(div.getDdlDaichoShubetsu().getSelectedKey())) {
            div.getRadKaigoHokenShisetsu().setVisible(false);
            div.getRadOtherTokureiShisetsu().setVisible(false);
            div.getRadTekiyoJyogaiShisetsu().setVisible(false);
            div.getRadTekiyoJyogaiShisetsu().setSelectedKey(ShisetsuType.適用除外施設.getCode());
        }
    }

    /**
     * 入所施設名称の取得。
     *
     */
    public void selectShiSeTuMeiSyo() {

        if ((台帳種別表示有り.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示有り, RString.class))
                && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示無し, RString.class))
                && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示無し, RString.class))
                && 被保険者.equals(ViewStateHolder.get(ViewStateKeys.被保険者, RString.class))
                && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示無し, RString.class))
                && 他市町村住所地特例者.equals(ViewStateHolder.get(ViewStateKeys.他市町村住所地特例者, RString.class))
                && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())) {

            div.getRadOtherTokureiShisetsu().getDisabledItem().clear();
            div.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
            ShisetsuJohoInputGuideFinder shisetsuJoho = new ShisetsuJohoInputGuideFinder();
            SearchResult<KaigoJigyoshaInputGuide> kaigoJigyosha = shisetsuJoho.getKaigoJigyoshaInputGuide(new KaigoJigyoshaNo(div.getTxtNyuryokuShisetsuKodo().getValue()), FlexibleDate.getNowDate());
            if (!kaigoJigyosha.records().isEmpty()) {
                div.getTxtNyuryokuShisetsuMeisho().setValue(kaigoJigyosha.records().get(0).get事業者名称().value());
                div.getTxtNyuryokuShisetsuKodo().setValue(kaigoJigyosha.records().get(0).get事業者番号().value());
            } else {

                div.getTxtNyuryokuShisetsuMeisho().clearValue();
            }
        }

        if ((台帳種別表示有り.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示有り, RString.class))
                && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示無し, RString.class))
                && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示無し, RString.class))
                && 被保険者.equals(ViewStateHolder.get(ViewStateKeys.被保険者, RString.class))
                && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示無し, RString.class))
                && 他市町村住所地特例者.equals(ViewStateHolder.get(ViewStateKeys.他市町村住所地特例者, RString.class))
                && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())) {

            div.getRadKaigoHokenShisetsu().getDisabledItem().clear();
            div.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
            ShisetsuJohoInputGuideFinder shisetsuJoho = new ShisetsuJohoInputGuideFinder();
            SearchResult<KaigoJogaiTokureiTaishoShisetsuInputGuide> kaigoJogaiTokureiTaishoShisetsu = shisetsuJoho.
                    getKaigoJogaiTokureiTaishoShisetsuInputGuide(ShisetsuType.住所地特例対象施設.getCode(), new JigyoshaNo(div.getTxtNyuryokuShisetsuKodo().getValue()), FlexibleDate.getNowDate());
            if (!kaigoJogaiTokureiTaishoShisetsu.records().isEmpty()) {

                div.getTxtNyuryokuShisetsuMeisho().setValue(kaigoJogaiTokureiTaishoShisetsu.records().get(0).get事業者名称().value());
            } else {

                div.getTxtNyuryokuShisetsuMeisho().clearValue();
            }
        }

        if ((台帳種別表示有り.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示有り, RString.class))
                && div.getRadTekiyoJyogaiShisetsu().getSelectedKey() != null
                && !div.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示無し, RString.class))
                && div.getRadTekiyoJyogaiShisetsu().getSelectedKey() != null
                && !div.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示無し, RString.class))
                && 適用除外者.equals(ViewStateHolder.get(ViewStateKeys.適用除外者, RString.class)))) {

            div.getRadKaigoHokenShisetsu().getDisabledItem().clear();
            div.getRadOtherTokureiShisetsu().getDisabledItem().clear();
            ShisetsuJohoInputGuideFinder shisetsuJoho = new ShisetsuJohoInputGuideFinder();
            SearchResult<KaigoJogaiTokureiTaishoShisetsuInputGuide> kaigoJogaiTokureiTaishoShisetsu = shisetsuJoho.
                    getKaigoJogaiTokureiTaishoShisetsuInputGuide(ShisetsuType.住所地特例対象施設.getCode(), new JigyoshaNo(div.getTxtNyuryokuShisetsuKodo().getValue()), FlexibleDate.getNowDate());
            if (!kaigoJogaiTokureiTaishoShisetsu.records().isEmpty()) {

                div.getTxtNyuryokuShisetsuMeisho().setValue(kaigoJogaiTokureiTaishoShisetsu.records().get(0).get事業者名称().value());
            } else {

                div.getTxtNyuryokuShisetsuMeisho().clearValue();
            }
        }

    }

    private List<KeyValueDataSource> ドロップダウンの設定() {

        List<KeyValueDataSource> dataSource = new ArrayList();

        KeyValueDataSource dataSource1 = new KeyValueDataSource();
        dataSource1.setKey(DaichoType.被保険者.getCode());
        dataSource1.setValue(DaichoType.被保険者.getName());
        dataSource.add(dataSource1);

        KeyValueDataSource dataSource2 = new KeyValueDataSource();
        dataSource2.setKey(DaichoType.他市町村住所地特例者.getCode());
        dataSource2.setValue(DaichoType.他市町村住所地特例者.getName());
        dataSource.add(dataSource2);

        KeyValueDataSource dataSource3 = new KeyValueDataSource();
        dataSource3.setKey(DaichoType.適用除外者.getCode());
        dataSource3.setValue(DaichoType.適用除外者.getName());
        dataSource.add(dataSource3);
        return dataSource;
    }
}
