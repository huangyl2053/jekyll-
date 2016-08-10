package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.shisetujyoho.KaigoJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dbz.business.core.shisetujyoho.KaigoJogaiTokureiTaishoShisetsuInputGuide;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu.JigyosyaType;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.service.core.shisetsu.ShisetsuJohoInputGuideFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 施設情報のHandlerクラスです。
 *
 * @reamsid_L DBA-0190-010 houtianpeng
 */
public class ShisetsuJohoHandler {

    private final ShisetsuJohoCommonChildDivDiv div;
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
    public ShisetsuJohoHandler(ShisetsuJohoCommonChildDivDiv div) {
        this.div = div;
    }

    /**
     * 施設情報に初期化を設定する。
     *
     */
    public void initialize() {

        if (ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class) == null) {

            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        if (台帳種別表示有り.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))) {
            
            div.getDdlDaichoShubetsu().setDataSource(ドロップダウンの設定());
            div.getRadKaigoHokenShisetsu().setVisible(true);
            div.getRadOtherTokureiShisetsu().setVisible(true);
            div.getRadTekiyoJyogaiShisetsu().setVisible(true);
            div.getDdlDaichoShubetsu().setSelectedKey(DaichoType.被保険者.getコード());
            div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getコード());
            div.getRadOtherTokureiShisetsu().getDisabledItem().clear();
            div.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
        }
        if (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && !被保険者.equals(ViewStateHolder.get(ViewStateKeys.被保険者, RString.class))
                && !他市町村住所地特例者.equals(ViewStateHolder.get(ViewStateKeys.他市町村住所地特例者, RString.class))
                && !適用除外者.equals(ViewStateHolder.get(ViewStateKeys.適用除外者, RString.class))) {

            div.getRadKaigoHokenShisetsu().setVisible(true);
            div.getRadOtherTokureiShisetsu().setVisible(true);
            div.getRadTekiyoJyogaiShisetsu().setVisible(true);
            div.getDdlDaichoShubetsu().setVisible(false);
            div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getコード());
            div.getRadOtherTokureiShisetsu().getDisabledItem().clear();
            div.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
        }

        if (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))) {
            if (被保険者.equals(ViewStateHolder.get(ViewStateKeys.被保険者, RString.class))) {
                div.getRadTekiyoJyogaiShisetsu().setVisible(false);
                div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getコード());
                div.getDdlDaichoShubetsu().setVisible(false);
                div.getRadOtherTokureiShisetsu().getDisabledItem().clear();
                div.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
            }
            if (他市町村住所地特例者.equals(ViewStateHolder.get(ViewStateKeys.他市町村住所地特例者, RString.class))) {

                div.getRadTekiyoJyogaiShisetsu().setVisible(false);
                div.getDdlDaichoShubetsu().setVisible(false);
                div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getコード());
                div.getRadOtherTokureiShisetsu().getDisabledItem().clear();
                div.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
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

        if (DaichoType.被保険者.getコード().equals(div.getDdlDaichoShubetsu().getSelectedKey())) {
            div.getRadKaigoHokenShisetsu().setVisible(true);
            div.getRadOtherTokureiShisetsu().setVisible(true);
            div.getRadTekiyoJyogaiShisetsu().setVisible(true);
            div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getコード());
            div.getRadOtherTokureiShisetsu().getDisabledItem().clear();
            div.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
        }
        if (DaichoType.他市町村住所地特例者.getコード().equals(div.getDdlDaichoShubetsu().getSelectedKey())) {
            div.getRadKaigoHokenShisetsu().setVisible(true);
            div.getRadOtherTokureiShisetsu().setVisible(true);
            div.getRadTekiyoJyogaiShisetsu().setVisible(false);
            div.getRadKaigoHokenShisetsu().setSelectedKey(ShisetsuType.介護保険施設.getコード());
            div.getRadOtherTokureiShisetsu().getDisabledItem().clear();
            div.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
        }
        if (DaichoType.適用除外者.getコード().equals(div.getDdlDaichoShubetsu().getSelectedKey())) {
            div.getRadKaigoHokenShisetsu().setVisible(false);
            div.getRadOtherTokureiShisetsu().setVisible(false);
            div.getRadTekiyoJyogaiShisetsu().setVisible(false);
        }
    }

    /**
     * 入所施設名称の取得。
     *
     */
    public void selectShiSeTuMeiSyo() {

        if ((台帳種別表示有り.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && 被保険者.equals(ViewStateHolder.get(ViewStateKeys.被保険者, RString.class))
                && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && 他市町村住所地特例者.equals(ViewStateHolder.get(ViewStateKeys.他市町村住所地特例者, RString.class))
                && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())) {

            div.getRadOtherTokureiShisetsu().getDisabledItem().clear();
            div.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
            ShisetsuJohoInputGuideFinder shisetsuJoho = new ShisetsuJohoInputGuideFinder();
            SearchResult<KaigoJigyoshaInputGuide> kaigoJigyosha = shisetsuJoho.getKaigoJigyoshaInputGuide(
                    new JigyoshaNo(div.getTxtNyuryokuShisetsuKodo().getValue()));
            if (!kaigoJigyosha.records().isEmpty()) {
                div.getTxtNyuryokuShisetsuMeisho().setValue(kaigoJigyosha.records().get(0).get事業者名称().value());
                div.getTxtNyuryokuShisetsuKodo().setValue(kaigoJigyosha.records().get(0).get事業者番号().value());
            } else {

                div.getTxtNyuryokuShisetsuMeisho().clearValue();
            }
        }
        if ((台帳種別表示有り.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && 被保険者.equals(ViewStateHolder.get(ViewStateKeys.被保険者, RString.class))
                && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && 他市町村住所地特例者.equals(ViewStateHolder.get(ViewStateKeys.他市町村住所地特例者, RString.class))
                && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())) {

            div.getRadKaigoHokenShisetsu().getDisabledItem().clear();
            div.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
            ShisetsuJohoInputGuideFinder shisetsuJoho = new ShisetsuJohoInputGuideFinder();
            SearchResult<KaigoJogaiTokureiTaishoShisetsuInputGuide> kaigoJogaiTokureiTaisho = shisetsuJoho.
                    getKaigoJogaiTokureiTaishoShisetsuInputGuide(JigyosyaType.住所地特例対象施設.getコード());
            if (!kaigoJogaiTokureiTaisho.records().isEmpty()) {

                div.getTxtNyuryokuShisetsuMeisho().setValue(kaigoJogaiTokureiTaisho.records().get(0).get事業者名称().value());
            } else {

                div.getTxtNyuryokuShisetsuMeisho().clearValue();
            }
        }
        if ((台帳種別表示有り.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && div.getRadTekiyoJyogaiShisetsu().getSelectedKey() != null
                && !div.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && div.getRadTekiyoJyogaiShisetsu().getSelectedKey() != null
                && !div.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && 適用除外者.equals(ViewStateHolder.get(ViewStateKeys.適用除外者, RString.class)))) {

            div.getRadKaigoHokenShisetsu().getDisabledItem().clear();
            div.getRadOtherTokureiShisetsu().getDisabledItem().clear();
            ShisetsuJohoInputGuideFinder shisetsuJoho = new ShisetsuJohoInputGuideFinder();
            SearchResult<KaigoJogaiTokureiTaishoShisetsuInputGuide> kaigoJogaiTokureiTaisho = shisetsuJoho.
                    getKaigoJogaiTokureiTaishoShisetsuInputGuide(JigyosyaType.適用除外施設.getコード());
            if (!kaigoJogaiTokureiTaisho.records().isEmpty()) {

                div.getTxtNyuryokuShisetsuMeisho().setValue(kaigoJogaiTokureiTaisho.records().get(0).get事業者名称().value());
            } else {

                div.getTxtNyuryokuShisetsuMeisho().clearValue();
            }
        }               
            if (DaichoType.被保険者.getコード().equals(div.getDdlDaichoShubetsu().getSelectedKey())) {
                div.getRadKaigoHokenShisetsu().setVisible(true);
                div.getRadOtherTokureiShisetsu().setVisible(true);
                div.getRadTekiyoJyogaiShisetsu().setVisible(true);
            }
            if (DaichoType.他市町村住所地特例者.getコード().equals(div.getDdlDaichoShubetsu().getSelectedKey())) {
                div.getRadKaigoHokenShisetsu().setVisible(true);
                div.getRadOtherTokureiShisetsu().setVisible(true);
                div.getRadTekiyoJyogaiShisetsu().setVisible(false);
            }
            if (DaichoType.適用除外者.getコード().equals(div.getDdlDaichoShubetsu().getSelectedKey())) {
                div.getRadKaigoHokenShisetsu().setVisible(false);
                div.getRadOtherTokureiShisetsu().setVisible(false);
                div.getRadTekiyoJyogaiShisetsu().setVisible(false);
            }                       
    }

    private List<KeyValueDataSource> ドロップダウンの設定() {

        List<KeyValueDataSource> dataSourceList = new ArrayList();

        for (DaichoType type : DaichoType.values()) {

            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(type.getコード());
            dataSource.setValue(type.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    /**
     * 入所施設コードを取得する。
     *
     * @return 入所施設コード
     */
    public RString getNyuryokuShisetsuKodo() {
        return div.getTxtNyuryokuShisetsuKodo().getValue();
    }

    /**
     * 入所施設名称を取得する。
     *
     * @return 入所施設名称
     */
    public RString getNyuryokuShisetsuMeisho() {
        return div.getTxtNyuryokuShisetsuMeisho().getValue();
    }

    /**
     * 入所施設コードを渡すと入所施設名称を取得して表示する。
     *
     * @param nyuryokuShisetsucode 入所施設コード
     */
    public void setNyuryokuShisetsuKodo(RString nyuryokuShisetsucode) {
        div.getTxtNyuryokuShisetsuKodo().setValue(nyuryokuShisetsucode);
        this.selectShiSeTuMeiSyo();
    }

    /**
     * 台帳種別の取得。
     *
     * @return 台帳種別
     */
    public RString getDdlDaichoShubetsu() {
        return div.getDdlDaichoShubetsu().getSelectedKey();
    }

    /**
     * 施設種類の取得。
     *
     * @return 施設種類
     */
    public RString get施設種類() {
        if (div.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty()) {

            return div.getRadKaigoHokenShisetsu().getSelectedKey();
        } else if (div.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty()) {

            return div.getRadOtherTokureiShisetsu().getSelectedKey();
        } else if (div.getRadTekiyoJyogaiShisetsu().getSelectedKey() != null
                && !div.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty()) {

            return div.getRadTekiyoJyogaiShisetsu().getSelectedKey();
        } else if ((div.getRadKaigoHokenShisetsu().getSelectedKey() == null
                || div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
                && (div.getRadOtherTokureiShisetsu().getSelectedKey() == null
                || div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
                && (div.getRadTekiyoJyogaiShisetsu().getSelectedKey() == null
                || div.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty())) {

            return ShisetsuType.適用除外施設.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 施設種類の設定。
     *
     * @param key 施設種類
     */
    public void set施設種類(RString key) {

        if (ShisetsuType.介護保険施設.getコード().equals(key)) {
            div.getRadKaigoHokenShisetsu().setSelectedKey(key);
        }
        if (ShisetsuType.住所地特例対象施設.getコード().equals(key)) {
            div.getRadOtherTokureiShisetsu().setSelectedKey(key);
        }
        if (ShisetsuType.適用除外施設.getコード().equals(key)) {
            div.getRadTekiyoJyogaiShisetsu().setSelectedKey(key);
        }
    }

    /**
     * 台帳種別の設定。
     *
     * @param key 台帳種別
     */
    public void set台帳種別(RString key) {

        if (DaichoType.被保険者.getコード().equals(key)) {
            div.getDdlDaichoShubetsu().setSelectedKey(key);
        }
        if (DaichoType.他市町村住所地特例者.getコード().equals(key)) {
            div.getDdlDaichoShubetsu().setSelectedKey(key);
        }
        if (DaichoType.適用除外者.getコード().equals(key)) {
            div.getDdlDaichoShubetsu().setSelectedKey(key);
        }
    }

    /**
     * 入所施設名称の取得。
     *
     * @param 入所施設コード 入所施設コード
     */
    public void get入所施設名称(JigyoshaNo 入所施設コード) {

        if ((台帳種別表示有り.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && 被保険者.equals(ViewStateHolder.get(ViewStateKeys.被保険者, RString.class))
                && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && 他市町村住所地特例者.equals(ViewStateHolder.get(ViewStateKeys.他市町村住所地特例者, RString.class))
                && div.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !div.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())) {

            div.getRadOtherTokureiShisetsu().getDisabledItem().clear();
            div.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
            ShisetsuJohoInputGuideFinder shisetsuJoho = new ShisetsuJohoInputGuideFinder();
            SearchResult<KaigoJigyoshaInputGuide> kaigoJigyosha = shisetsuJoho.getKaigoJigyoshaInputGuide(入所施設コード);
            if (!kaigoJigyosha.records().isEmpty()) {
                div.getTxtNyuryokuShisetsuMeisho().setValue(kaigoJigyosha.records().get(0).get事業者名称().value());
                div.getTxtNyuryokuShisetsuKodo().setValue(kaigoJigyosha.records().get(0).get事業者番号().value());
            } else {

                div.getTxtNyuryokuShisetsuMeisho().clearValue();
            }
        }
        if ((台帳種別表示有り.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && 被保険者.equals(ViewStateHolder.get(ViewStateKeys.被保険者, RString.class))
                && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && 他市町村住所地特例者.equals(ViewStateHolder.get(ViewStateKeys.他市町村住所地特例者, RString.class))
                && div.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !div.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())) {

            div.getRadKaigoHokenShisetsu().getDisabledItem().clear();
            div.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
            ShisetsuJohoInputGuideFinder shisetsuJoho = new ShisetsuJohoInputGuideFinder();
            SearchResult<KaigoJogaiTokureiTaishoShisetsuInputGuide> kaigoJogaiTokureiTaisho = shisetsuJoho.
                    getKaigoJogaiTokureiTaishoShisetsuInputGuide(ShisetsuType.住所地特例対象施設.getコード());
            if (!kaigoJogaiTokureiTaisho.records().isEmpty()) {

                div.getTxtNyuryokuShisetsuMeisho().setValue(kaigoJogaiTokureiTaisho.records().get(0).get事業者名称().value());
            } else {

                div.getTxtNyuryokuShisetsuMeisho().clearValue();
            }
        }
        if ((台帳種別表示有り.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && div.getRadTekiyoJyogaiShisetsu().getSelectedKey() != null
                && !div.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && div.getRadTekiyoJyogaiShisetsu().getSelectedKey() != null
                && !div.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty())
                || (台帳種別表示無し.equals(ViewStateHolder.get(ViewStateKeys.台帳種別表示, RString.class))
                && 適用除外者.equals(ViewStateHolder.get(ViewStateKeys.適用除外者, RString.class)))) {

            div.getRadKaigoHokenShisetsu().getDisabledItem().clear();
            div.getRadOtherTokureiShisetsu().getDisabledItem().clear();
            ShisetsuJohoInputGuideFinder shisetsuJoho = new ShisetsuJohoInputGuideFinder();
            SearchResult<KaigoJogaiTokureiTaishoShisetsuInputGuide> kaigoJogaiTokureiTaisho = shisetsuJoho.
                    getKaigoJogaiTokureiTaishoShisetsuInputGuide(ShisetsuType.適用除外施設.getコード());
            if (!kaigoJogaiTokureiTaisho.records().isEmpty()) {

                div.getTxtNyuryokuShisetsuMeisho().setValue(kaigoJogaiTokureiTaisho.records().get(0).get事業者名称().value());
            } else {

                div.getTxtNyuryokuShisetsuMeisho().clearValue();
            }
        }
    }

    /**
     * 事業者名称の設定.
     *
     * @param meisho 事業者名称
     */
    public void setShisetsuMeisho(RString meisho) {
        div.getTxtNyuryokuShisetsuMeisho().setValue(meisho);
    }

    /**
     * クリア.
     *
     */
    public void clear() {
        initialize();
        div.getTxtNyuryokuShisetsuMeisho().clearValue();
        div.getTxtNyuryokuShisetsuKodo().clearValue();
    }
}
