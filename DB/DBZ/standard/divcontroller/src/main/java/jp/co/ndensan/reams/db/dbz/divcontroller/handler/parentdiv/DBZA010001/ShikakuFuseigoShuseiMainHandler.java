/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZA010001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaishaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokureiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaishaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo.ShikakuFuseigoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysNenreiTotatsuKijunJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.fuseigoriyu.FuseigoRiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu.JogaiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu.JogaiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.tatokureiidojiyu.TatokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.tatokureiidojiyu.TatokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001.ShikakuFuseigoShuseiMainDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001.dgShikakuFuseigoIchiran_Row;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayDateFormat;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 資格不整合修正の抽象Handlerクラスです。
 *
 * @reamsid_L DBB-0630-010 chengsanyuan
 */
public class ShikakuFuseigoShuseiMainHandler {

    private final ShikakuFuseigoShuseiMainDiv div;

    private static final RString GRID_BR = new RString("<br/>");
    private static final int NUMBER_FLAG_1 = 1;
    private static final int NUMBER_FLAG_2 = 2;
    private static final int NUMBER_FLAG_3 = 3;
    private static final int NUMBER_FLAG_4 = 4;
    private final int 第１号被保険者到達基準年齢;

    /**
     * コンストラクタです。
     *
     * @param div 資格不整合修正Div
     */
    public ShikakuFuseigoShuseiMainHandler(ShikakuFuseigoShuseiMainDiv div) {
        this.div = div;
        第１号被保険者到達基準年齢 = Integer.valueOf(DbBusinessConfig.get(
                ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第１号被保険者到達基準年齢,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString());
    }

    /**
     *
     * 資格不整合修正初期化の設定します。
     *
     * @param resultList 資格不整合一覧情報
     */
    public void load(List<ShikakuFuseigoBusiness> resultList) {
        List<KeyValueDataSource> list = new ArrayList<>();
        for (DaichoType type : DaichoType.values()) {
            KeyValueDataSource key = new KeyValueDataSource(type.getコード(), type.get名称());
            list.add(key);
        }
        div.getDdlDaichoShubetsu().setDataSource(list);
        div.getChkTaishoGaiHyoji().setSelectedItemsByKey(Collections.<RString>emptyList());
        div.getDdlDaichoShubetsu().setSelectedKey(DaichoType.被保険者.getコード());
        setDataGridByDaichoType(resultList, DaichoType.被保険者.getコード(), false);
    }

    /**
     * 台帳種別にて、画面のグリッドの値を設定します。
     *
     * @param resultList 資格不整合一覧情報
     * @param daichoType 台帳種別
     * @param gaiHyoji 対象外
     */
    public void setDataGridByDaichoType(List<ShikakuFuseigoBusiness> resultList, RString daichoType, boolean gaiHyoji) {
        List<dgShikakuFuseigoIchiran_Row> rowList = new ArrayList<>();
        RDateTime 処理日時 = null;
        for (ShikakuFuseigoBusiness business : resultList) {
            if (処理日時 == null) {
                処理日時 = business.get処理日時();
            }
            if (business.get処理日時() != null && business.get処理日時().isAfter(処理日時)) {
                処理日時 = business.get処理日時();
            }
            if (daichoType.equals(business.get台帳種別()) && gaiHyoji == business.is対象外フラグ()) {
                dgShikakuFuseigoIchiran_Row row = new dgShikakuFuseigoIchiran_Row();
                row.setIgnoree(business.is対象外フラグ() ? new RString("○") : RString.EMPTY);
                if (business.get被保険者番号() == null || business.get識別コード() == null) {
                    continue;
                }
                row.setHihoNo(business.get被保険者番号().value());
                row.setShikibetsuCode(business.get識別コード().value());
                row.setHihoNoAndShikibetsuCode(toAppendBR(business.get被保険者番号().value(), business.get識別コード().value()));
                row.setKanaShimei(business.get氏名カナ().value());
                row.setShimei(business.get氏名().value());
                row.setKanaAndShimsei(toAppendBR(business.get氏名カナ().value(), business.get氏名().value()));
                row.setJuminJotai(business.get住民状態());
                set住民状態And生年月日(business.get住民状態(), business.is日本人(), business.get生年月日(), row);
                row.getTxtBirthDay().setValue(business.get生年月日());
                row.setSeibetsu(business.get性別());
                row.setNenrei(business.get年齢());
                row.setSeibetsuAndNenrei(toAppendBR(business.get性別(), business.get年齢()));
                row.setFuseigoNaiyo(FuseigoRiyu.toValue(business.get不整合理由コード()).get名称());
                rowList.add(row);
            }
        }
        div.getDgShikakuFuseigoIchiran().setDataSource(rowList);
        div.getTxtShoriDateTime().setValue(rdateToRstr(処理日時));
    }

    private void set住民状態And生年月日(RString 住民状態, boolean is日本人, FlexibleDate 生年月日, dgShikakuFuseigoIchiran_Row row) {
        if (is日本人) {
            row.getTxtBirthDay().setDisplayFormatEnum(DisplayDateFormat.平YYMMDD);
            if (生年月日 != null && !生年月日.isEmpty()) {
                row.setJuminJotaiAndBirthDay(toAppendBR(住民状態,
                        生年月日.wareki().eraType(EraType.KANJI_RYAKU).toDateString()));
            } else {
                row.setJuminJotaiAndBirthDay(toAppendBR(住民状態,
                        RString.EMPTY));
            }

        } else {
            row.getTxtBirthDay().setDisplayFormatEnum(DisplayDateFormat.YYYYperiodMMperiodDD);
            if (生年月日 != null && !生年月日.isEmpty()) {
                row.setJuminJotaiAndBirthDay(toAppendBR(住民状態,
                        生年月日.seireki().toDateString()));
            } else {
                row.setJuminJotaiAndBirthDay(toAppendBR(住民状態,
                        RString.EMPTY));
            }
        }
    }

    /**
     * 資格取得エリア、取得除外エリアの表示切替
     *
     * @param 不整合理由 不整合理由
     */
    public void setSyutokuJogai(FuseigoRiyu 不整合理由) {
        if (不整合理由 == FuseigoRiyu.資格管理情報未登録者) {
            if (div.getChkShutokuJogai().isAllSelected()) {
                div.getDdlShikakuShutokuJiyu().setDisabled(true);
                div.getTxtShikakuShutokuTodokedeYmd().setDisabled(true);
                div.getTxtShikakuShutokuYmd().setDisabled(true);
                div.getTxtShutokuJogaiYmd().setDisabled(false);
                div.getTxtShutokuJogaiRiyu().setDisabled(false);
            } else {
                div.getDdlShikakuShutokuJiyu().setDisabled(false);
                div.getTxtShikakuShutokuTodokedeYmd().setDisabled(false);
                div.getTxtShikakuShutokuYmd().setDisabled(false);
                div.getTxtShutokuJogaiYmd().setDisabled(true);
                div.getTxtShutokuJogaiRiyu().setDisabled(true);
            }
        }
    }

    /**
     * 住所地特例適用エリア、資格喪失エリアの表示切替
     *
     * @param 不整合理由 不整合理由
     */
    public void setShikakuSoushitu(FuseigoRiyu 不整合理由) {
        if (不整合理由 == FuseigoRiyu.資格取得者_転出者
                || 不整合理由 == FuseigoRiyu.資格喪失日_転出予定者 || 不整合理由 == FuseigoRiyu.資格喪失日_転出確定者) {
            if (div.getChkJutoku().isAllSelected()) {
                div.getTxtShikakuSoshitsuYmd().setDisabled(true);
                div.getTxtShikakuSoshitsuTodokedeYmd().setDisabled(true);
                div.getDdlJutokuTekiyoJiyu().setDisabled(false);
                div.getTxtJutokuTekiyoDate().setDisabled(false);
                div.getTxtJutokuTekiyoTodokedeDate().setDisabled(false);
            } else {
                div.getTxtShikakuSoshitsuYmd().setDisabled(false);
                div.getTxtShikakuSoshitsuTodokedeYmd().setDisabled(false);
                div.getDdlJutokuTekiyoJiyu().setDisabled(true);
                div.getTxtJutokuTekiyoDate().setDisabled(true);
                div.getTxtJutokuTekiyoTodokedeDate().setDisabled(true);
            }
        }
    }

    /**
     * 他特の情報を設定します
     *
     * @param 不整合理由 不整合理由
     * @param 修正後の他特の情報 修正後の他特の情報
     * @return TashichosonJushochiTokurei
     */
    public TashichosonJushochiTokurei set他特の情報(FuseigoRiyu 不整合理由, TashichosonJushochiTokurei 修正後の他特の情報) {
        TashichosonJushochiTokureiBuilder 他特の情報修正後Builder = 修正後の他特の情報.createBuilderForEdit();
        switch (不整合理由) {
            case 他住所地特例適用日_転入者:
                他特の情報修正後Builder.set他市町村住所地特例適用事由コード(div.getDdlTatokuTekiyoJiyu().getSelectedKey());
                他特の情報修正後Builder.set適用年月日(div.getTxtTatokuTekiyoYmd().getValue());
                他特の情報修正後Builder.set適用届出年月日(div.getTxtTatokuTekiyoTodokedeYmd().getValue());
                break;
            default:
                他特の情報修正後Builder.set他市町村住所地特例解除事由コード(div.getDdlTatokuKaijoJiyu().getSelectedKey());
                他特の情報修正後Builder.set解除年月日(div.getTxtTatokuKaijoYmd().getValue());
                他特の情報修正後Builder.set解除届出年月日(div.getTxtTatokuKaijoTodokedeYmd().getValue());
                break;
        }
        return 他特の情報修正後Builder.build();
    }

    /**
     * 除外の情報を設定します
     *
     * @param 不整合理由 不整合理由
     * @param 修正後の除外の情報 修正後の除外の情報
     * @return TekiyoJogaisha
     */
    public TekiyoJogaisha set除外の情報(FuseigoRiyu 不整合理由, TekiyoJogaisha 修正後の除外の情報) {
        TekiyoJogaishaBuilder 除外の情報修正後Builder = 修正後の除外の情報.createBuilderForEdit();
        switch (不整合理由) {
            case 除外適用日_転入者:
                除外の情報修正後Builder.set適用除外適用事由コード(div.getDdlTekiyoJogaiTekiyoJiyu().getSelectedKey());
                除外の情報修正後Builder.set適用年月日(div.getTxtTekiyoJogaiTekiyoYmd().getValue());
                除外の情報修正後Builder.set適用届出年月日(div.getTxtTekiyoJogaiTekiyoTodokedeYmd().getValue());
                break;
            default:
                除外の情報修正後Builder.set適用除外解除事由コード(div.getDdlTekiyoJogaiKaijoJiyu().getSelectedKey());
                除外の情報修正後Builder.set解除年月日(div.getTxtTekiyoJogaiKaijoYmd().getValue());
                除外の情報修正後Builder.set解除届出年月日(div.getTxtTekiyoJogaiKaijoTodokedeYmd().getValue());
                break;
        }
        return 除外の情報修正後Builder.build();
    }

    /**
     * 資格の情報を設定します
     *
     * @param 不整合理由 不整合理由
     * @param 修正後の資格の情報 修正後の資格の情報
     * @return HihokenshaDaicho
     */
    public HihokenshaDaicho set資格の情報(FuseigoRiyu 不整合理由, HihokenshaDaicho 修正後の資格の情報) {
        switch (不整合理由) {
            case 資格変更者_１号被保険者到達:
                HihokenshaDaicho 資格の情報1 = new HihokenshaDaicho(修正後の資格の情報.get被保険者番号(),
                        div.getTxtShikakuHenkoYmd().getValue(), 修正後の資格の情報.get枝番());
                HihokenshaDaichoBuilder builder1 = set資格の情報Common(資格の情報1, 修正後の資格の情報, NUMBER_FLAG_1);
                builder1.set資格変更事由コード(div.getDdlShikakuHenkoJiyu().getSelectedKey());
                builder1.set資格変更年月日(div.getTxtShikakuHenkoYmd().getValue());
                builder1.set資格変更届出年月日(div.getTxtShikakuHenkoTodokedeYmd().getValue());
                builder1.set第1号資格取得年月日(div.getTxtShikakuHenkoYmd().getValue());
                builder1.set異動事由コード(div.getDdlShikakuHenkoJiyu().getSelectedKey());
                return builder1.build();
            case 資格取得日_転入者:
            case 資格取得日_年齢到達者:
            case 資格管理情報未登録者:
                if (!div.getChkShutokuJogai().isAllSelected()) {
                    HihokenshaDaicho 資格の情報2 = new HihokenshaDaicho(修正後の資格の情報.get被保険者番号(),
                            div.getTxtShikakuShutokuYmd().getValue(), 修正後の資格の情報.get枝番());
                    HihokenshaDaichoBuilder builder2 = set資格の情報Common(資格の情報2, 修正後の資格の情報, NUMBER_FLAG_2);
                    builder2.set第1号資格取得年月日(div.getTxtShikakuShutokuYmd().getValue());
                    builder2.set異動事由コード(div.getDdlShikakuHenkoJiyu().getSelectedKey());
                    builder2.set資格取得事由コード(div.getDdlShikakuShutokuJiyu().getSelectedKey());
                    builder2.set資格取得年月日(div.getTxtShikakuShutokuYmd().getValue());
                    builder2.set資格取得届出年月日(div.getTxtShikakuShutokuTodokedeYmd().getValue());
                    return builder2.build();
                }
                break;
            default:
                if (div.getChkJutoku().isAllSelected()) {
                    HihokenshaDaicho 資格の情報4 = new HihokenshaDaicho(修正後の資格の情報.get被保険者番号(),
                            div.getTxtJutokuTekiyoDate().getValue(), 修正後の資格の情報.get枝番());
                    HihokenshaDaichoBuilder builder4 = set資格の情報Common(資格の情報4, 修正後の資格の情報, NUMBER_FLAG_4);
                    builder4.set異動事由コード(div.getDdlJutokuTekiyoJiyu().getSelectedKey());
                    builder4.set住所地特例適用事由コード(div.getDdlJutokuTekiyoJiyu().getSelectedKey());
                    builder4.set適用年月日(div.getTxtJutokuTekiyoDate().getValue());
                    builder4.set適用届出年月日(div.getTxtJutokuTekiyoTodokedeDate().getValue());
                    return builder4.build();
                } else {
                    HihokenshaDaicho 資格の情報5 = new HihokenshaDaicho(修正後の資格の情報.get被保険者番号(),
                            div.getTxtShikakuSoshitsuYmd().getValue(), 修正後の資格の情報.get枝番());
                    HihokenshaDaichoBuilder builder5 = set資格の情報Common(資格の情報5, 修正後の資格の情報, NUMBER_FLAG_3);
                    builder5.set異動事由コード(div.getDdlShikakuSoshitsuJiyu().getSelectedKey());
                    builder5.set資格喪失事由コード(div.getDdlShikakuSoshitsuJiyu().getSelectedKey());
                    builder5.set資格喪失年月日(div.getTxtShikakuSoshitsuYmd().getValue());
                    builder5.set資格喪失届出年月日(div.getTxtShikakuSoshitsuTodokedeYmd().getValue());
                    return builder5.build();
                }
        }
        return null;
    }

    /**
     * 取得除外の情報を設定します
     *
     * @param 不整合理由 不整合理由
     * @param 履歴番号 履歴番号
     * @param 修正後の資格の情報 修正後の資格の情報
     * @return ShikakuShutokuJogaisha
     */
    public ShikakuShutokuJogaisha set取得除外の情報(FuseigoRiyu 不整合理由, int 履歴番号, HihokenshaDaicho 修正後の資格の情報) {
        if (div.getChkShutokuJogai().isAllSelected() && 不整合理由 == FuseigoRiyu.資格管理情報未登録者) {
            ShikakuShutokuJogaisha 資格取得除外者 = new ShikakuShutokuJogaisha(修正後の資格の情報.get識別コード(), 履歴番号 + 1);
            ShikakuShutokuJogaishaBuilder builder3 = 資格取得除外者.createBuilderForEdit();
            builder3.set市町村コード(修正後の資格の情報.get市町村コード());
            builder3.set資格取得除外年月日(div.getTxtShutokuJogaiYmd().getValue());
            builder3.set資格取得除外理由(div.getTxtShutokuJogaiRiyu().getValue());
            return builder3.build();
        }
        return null;
    }

    private HihokenshaDaichoBuilder set資格の情報Common(HihokenshaDaicho 資格の情報, HihokenshaDaicho 修正後の資格の情報, int flag) {
        HihokenshaDaichoBuilder 資格の情報修正後Builder = 資格の情報.createBuilderForEdit();
        資格の情報修正後Builder.set市町村コード(修正後の資格の情報.get市町村コード());
        資格の情報修正後Builder.set識別コード(修正後の資格の情報.get識別コード());
        資格の情報修正後Builder.set被保険者区分コード(修正後の資格の情報.get被保険者区分コード());
        if (flag == NUMBER_FLAG_1) {
            資格の情報修正後Builder.set資格取得事由コード(修正後の資格の情報.get資格取得事由コード());
            資格の情報修正後Builder.set資格取得年月日(修正後の資格の情報.get資格取得年月日());
            資格の情報修正後Builder.set資格取得届出年月日(修正後の資格の情報.get資格取得届出年月日());
            資格の情報修正後Builder.set資格喪失事由コード(修正後の資格の情報.get資格喪失事由コード());
            資格の情報修正後Builder.set資格喪失年月日(修正後の資格の情報.get資格喪失年月日());
            資格の情報修正後Builder.set資格喪失届出年月日(修正後の資格の情報.get資格喪失届出年月日());
            資格の情報修正後Builder.set住所地特例適用事由コード(修正後の資格の情報.get住所地特例適用事由コード());
            資格の情報修正後Builder.set適用年月日(修正後の資格の情報.get適用年月日());
            資格の情報修正後Builder.set適用届出年月日(修正後の資格の情報.get適用届出年月日());
        }
        if (flag == NUMBER_FLAG_2) {
            資格の情報修正後Builder.set資格変更事由コード(修正後の資格の情報.get資格変更事由コード());
            資格の情報修正後Builder.set資格変更年月日(修正後の資格の情報.get資格変更年月日());
            資格の情報修正後Builder.set資格変更届出年月日(修正後の資格の情報.get資格変更届出年月日());
            資格の情報修正後Builder.set資格喪失事由コード(修正後の資格の情報.get資格喪失事由コード());
            資格の情報修正後Builder.set資格喪失年月日(修正後の資格の情報.get資格喪失年月日());
            資格の情報修正後Builder.set資格喪失届出年月日(修正後の資格の情報.get資格喪失届出年月日());
            資格の情報修正後Builder.set住所地特例適用事由コード(修正後の資格の情報.get住所地特例適用事由コード());
            資格の情報修正後Builder.set適用年月日(修正後の資格の情報.get適用年月日());
            資格の情報修正後Builder.set適用届出年月日(修正後の資格の情報.get適用届出年月日());
        }
        if (flag == NUMBER_FLAG_3) {
            資格の情報修正後Builder.set資格取得事由コード(修正後の資格の情報.get資格取得事由コード());
            資格の情報修正後Builder.set資格取得年月日(修正後の資格の情報.get資格取得年月日());
            資格の情報修正後Builder.set資格取得届出年月日(修正後の資格の情報.get資格取得届出年月日());
            資格の情報修正後Builder.set資格変更事由コード(修正後の資格の情報.get資格変更事由コード());
            資格の情報修正後Builder.set資格変更年月日(修正後の資格の情報.get資格変更年月日());
            資格の情報修正後Builder.set資格変更届出年月日(修正後の資格の情報.get資格変更届出年月日());
            資格の情報修正後Builder.set住所地特例適用事由コード(修正後の資格の情報.get住所地特例適用事由コード());
            資格の情報修正後Builder.set適用年月日(修正後の資格の情報.get適用年月日());
            資格の情報修正後Builder.set適用届出年月日(修正後の資格の情報.get適用届出年月日());
            資格の情報修正後Builder.set第1号資格取得年月日(修正後の資格の情報.get第1号資格取得年月日());
        }
        if (flag == NUMBER_FLAG_4) {
            資格の情報修正後Builder.set資格取得事由コード(修正後の資格の情報.get資格取得事由コード());
            資格の情報修正後Builder.set資格取得年月日(修正後の資格の情報.get資格取得年月日());
            資格の情報修正後Builder.set資格取得届出年月日(修正後の資格の情報.get資格取得届出年月日());
            資格の情報修正後Builder.set資格変更事由コード(修正後の資格の情報.get資格変更事由コード());
            資格の情報修正後Builder.set資格変更年月日(修正後の資格の情報.get資格変更年月日());
            資格の情報修正後Builder.set資格変更届出年月日(修正後の資格の情報.get資格変更届出年月日());
            資格の情報修正後Builder.set資格喪失事由コード(修正後の資格の情報.get資格喪失事由コード());
            資格の情報修正後Builder.set資格喪失年月日(修正後の資格の情報.get資格喪失年月日());
            資格の情報修正後Builder.set資格喪失届出年月日(修正後の資格の情報.get資格喪失届出年月日());
            資格の情報修正後Builder.set第1号資格取得年月日(修正後の資格の情報.get第1号資格取得年月日());
        }
        資格の情報修正後Builder.set住所地特例解除事由コード(修正後の資格の情報.get住所地特例解除事由コード());
        資格の情報修正後Builder.set解除年月日(修正後の資格の情報.get解除年月日());
        資格の情報修正後Builder.set解除届出年月日(修正後の資格の情報.get解除届出年月日());
        資格の情報修正後Builder.set住所地特例フラグ(修正後の資格の情報.get住所地特例フラグ());
        資格の情報修正後Builder.set広域内住所地特例フラグ(修正後の資格の情報.get広域内住所地特例フラグ());
        資格の情報修正後Builder.set広住特措置元市町村コード(修正後の資格の情報.get広住特措置元市町村コード());
        資格の情報修正後Builder.set旧市町村コード(修正後の資格の情報.get旧市町村コード());
        資格の情報修正後Builder.set論理削除フラグ(修正後の資格の情報.is論理削除フラグ());
        return 資格の情報修正後Builder;
    }

    /**
     * 適用除外の場合、不整合チェック結果（最新の不整合内容）を明細エリアに表示する
     *
     * @param 不整合理由 不整合理由
     * @param 個人情報 個人情報
     * @param 現在の他特の情報 現在の他特の情報
     * @param 修正後の他特の情報 修正後の他特の情報
     */
    public void setTekiyoMeisai(FuseigoRiyu 不整合理由, IKojin 個人情報, TekiyoJogaisha 現在の他特の情報, TekiyoJogaisha 修正後の他特の情報) {
        setDdlByTekiyo();
        switch (不整合理由) {
            case 除外適用日_転入者:
                div.getDdlTekiyoJogaiKaijoJiyu().setDisabled(true);
                div.getTxtTekiyoJogaiKaijoYmd().setDisabled(true);
                div.getTxtTekiyoJogaiKaijoTodokedeYmd().setDisabled(true);
                break;
            case 除外解除日_住基不一致:
            case 除外解除日_転出予定者:
            case 除外解除日_転出確定者:
                div.getDdlTekiyoJogaiTekiyoJiyu().setDisabled(true);
                div.getTxtTekiyoJogaiTekiyoYmd().setDisabled(true);
                div.getTxtTekiyoJogaiTekiyoTodokedeYmd().setDisabled(true);
                break;
            default:
                break;
        }
        div.getTxtFusugoNaiyo().setValue(不整合理由.get名称());
        div.getTxtShikibetsuCode().setValue(個人情報.get識別コード().value());
        div.getTxtJuminJotai().setValue(個人情報.get住民状態().住民状態略称());
        div.getTxtSeibetsu().setValue(個人情報.get性別().getCommonName());
        if (個人情報.is日本人()) {
            div.getTxtUmareYmd().setDisplayFormatEnum(DisplayDateFormat.平YYMMDD);
            div.getTxtShimei().setValue(toAppendFullSpace(
                    個人情報.get日本人氏名().getKana().value(), 個人情報.get日本人氏名().getName().value()));
        } else {
            div.getTxtUmareYmd().setDisplayFormatEnum(DisplayDateFormat.YYYYperiodMMperiodDD);
            div.getTxtShimei().setValue(toAppendFullSpace(
                    個人情報.get外国人氏名().getKana().value(), 個人情報.get外国人氏名().getName().value()));
        }
        div.getTxtUmareYmd().setValue(個人情報.get生年月日().toFlexibleDate());
        div.getTxtNenrei().setValue(個人情報.get年齢算出().get年齢());
        div.getTxt1goTotatsuYmd().setValue(個人情報.get年齢算出().get年齢到達日(第１号被保険者到達基準年齢));
        div.getTxtJukiTorokuJiyu().setValue(個人情報.get登録事由().get異動事由略称());
        div.getTxtTorokuIdoYmd().setValue(個人情報.get登録異動年月日());
        div.getTxtTorokuTodokedeYmd().setValue(個人情報.get登録届出年月日());
        div.getTxtJukiShojoJiyu().setValue(個人情報.get消除事由().get異動事由略称());
        div.getTxtShojoIdoYmd().setValue(個人情報.get消除異動年月日());
        div.getTxtShojoTodokedeYmd().setValue(個人情報.get消除届出年月日());
        div.getTxtTenshutsuYoteiYmd().setValue(個人情報.get転出予定().get異動年月日());
        div.getTxtTenshutsuKakuteiYmd().setValue(個人情報.get転出確定().get異動年月日());
        if (現在の他特の情報 != null) {
            try {
                div.getTxtCurrentTekiyoJogaiTekiyoJiyu().setValue(JogaiTekiyoJiyu.toValue(現在の他特の情報.get適用除外適用事由コード()).get名称());
            } catch (IllegalArgumentException e) {
                div.getTxtCurrentTekiyoJogaiTekiyoJiyu().setValue(RString.EMPTY);
            }
            div.getTxtCurrentTekiyoJogaiTekiyoYmd().setValue(現在の他特の情報.get適用年月日());
            div.getTxtCurrentTekiyoJogaiTekiyoTodokedeYmd().setValue(現在の他特の情報.get適用届出年月日());
            try {
                div.getTxtCurrentTekiyoJogaiKaijoJiyu().setValue(JogaiKaijoJiyu.toValue(現在の他特の情報.get適用除外解除事由コード()).get名称());
            } catch (IllegalArgumentException e) {
                div.getTxtCurrentTekiyoJogaiKaijoJiyu().setValue(RString.EMPTY);
            }
            div.getTxtCurrentTekiyoJogaiKaijoYmd().setValue(現在の他特の情報.get解除年月日());
            div.getTxtCurrentTekiyoJogaiKaijoTodokedeYmd().setValue(現在の他特の情報.get解除届出年月日());
        }
        if (修正後の他特の情報 != null) {
            if (!RString.isNullOrEmpty(修正後の他特の情報.get適用除外適用事由コード())) {
                div.getDdlTekiyoJogaiTekiyoJiyu().setSelectedKey(修正後の他特の情報.get適用除外適用事由コード());
            }
            div.getTxtTekiyoJogaiTekiyoYmd().setValue(修正後の他特の情報.get適用年月日());
            div.getTxtTekiyoJogaiTekiyoTodokedeYmd().setValue(修正後の他特の情報.get適用届出年月日());
            if (!RString.isNullOrEmpty(修正後の他特の情報.get適用除外解除事由コード())) {
                div.getDdlTekiyoJogaiKaijoJiyu().setSelectedKey(修正後の他特の情報.get適用除外解除事由コード());
            }
            div.getTxtTekiyoJogaiKaijoYmd().setValue(修正後の他特の情報.get解除年月日());
            div.getTxtTekiyoJogaiKaijoTodokedeYmd().setValue(修正後の他特の情報.get解除届出年月日());
        }
    }

    /**
     * 他市町村住所地特例者の場合、不整合チェック結果（最新の不整合内容）を明細エリアに表示する
     *
     * @param 不整合理由 不整合理由
     * @param 個人情報 個人情報
     * @param 現在の他特の情報 現在の他特の情報
     * @param 修正後の他特の情報 修正後の他特の情報
     */
    public void setTashichosonMeisai(FuseigoRiyu 不整合理由, IKojin 個人情報,
            TashichosonJushochiTokurei 現在の他特の情報, TashichosonJushochiTokurei 修正後の他特の情報) {
        setDdlByTashichoson();
        switch (不整合理由) {
            case 他住所地特例適用日_転入者:
                div.getDdlTatokuKaijoJiyu().setDisabled(true);
                div.getTxtTatokuKaijoYmd().setDisabled(true);
                div.getTxtTatokuKaijoTodokedeYmd().setDisabled(true);
                break;
            case 他住所地特例解除日_住基不一致:
            case 他住所地特例解除日_転出予定者:
            case 他住所地特例解除日_転出確定者:
                div.getDdlTatokuTekiyoJiyu().setDisabled(true);
                div.getTxtTatokuTekiyoYmd().setDisabled(true);
                div.getTxtTatokuTekiyoTodokedeYmd().setDisabled(true);
                break;
            default:
                break;
        }
        div.getTxtFusugoNaiyo().setValue(不整合理由.get名称());
        div.getTxtShikibetsuCode().setValue(個人情報.get識別コード().value());
        div.getTxtJuminJotai().setValue(個人情報.get住民状態().住民状態略称());
        div.getTxtSeibetsu().setValue(個人情報.get性別().getCommonName());
        if (個人情報.is日本人()) {
            div.getTxtUmareYmd().setDisplayFormatEnum(DisplayDateFormat.平YYMMDD);
            div.getTxtShimei().setValue(toAppendFullSpace(
                    個人情報.get日本人氏名().getKana().value(), 個人情報.get日本人氏名().getName().value()));
        } else {
            div.getTxtUmareYmd().setDisplayFormatEnum(DisplayDateFormat.YYYYperiodMMperiodDD);
            div.getTxtShimei().setValue(toAppendFullSpace(
                    個人情報.get外国人氏名().getKana().value(), 個人情報.get外国人氏名().getName().value()));
        }
        div.getTxtUmareYmd().setValue(個人情報.get生年月日().toFlexibleDate());
        div.getTxtNenrei().setValue(個人情報.get年齢算出().get年齢());
        div.getTxt1goTotatsuYmd().setValue(個人情報.get年齢算出().get年齢到達日(第１号被保険者到達基準年齢));
        div.getTxtJukiTorokuJiyu().setValue(個人情報.get登録事由().get異動事由略称());
        div.getTxtTorokuIdoYmd().setValue(個人情報.get登録異動年月日());
        div.getTxtTorokuTodokedeYmd().setValue(個人情報.get登録届出年月日());
        div.getTxtJukiShojoJiyu().setValue(個人情報.get消除事由().get異動事由略称());
        div.getTxtShojoIdoYmd().setValue(個人情報.get消除異動年月日());
        div.getTxtShojoTodokedeYmd().setValue(個人情報.get消除届出年月日());
        div.getTxtTenshutsuYoteiYmd().setValue(個人情報.get転出予定().get異動年月日());
        div.getTxtTenshutsuKakuteiYmd().setValue(個人情報.get転出確定().get異動年月日());
        if (現在の他特の情報 != null) {
            try {
                div.getTxtCurrentTatokuTekiyoJiyu().setValue(
                        TatokureiTekiyoJiyu.toValue(現在の他特の情報.get他市町村住所地特例適用事由コード()).get名称());
            } catch (IllegalArgumentException e) {
                div.getTxtCurrentTatokuTekiyoJiyu().setValue(RString.EMPTY);
            }
            div.getTxtCurrentTatokuTekiyoYmd().setValue(現在の他特の情報.get適用年月日());
            div.getTxtCurrentTatokuTekiyoTodokedeYmd().setValue(現在の他特の情報.get適用届出年月日());
            try {
                div.getTxtCurrentTatokuKaijoJiyu().setValue(
                        TatokureiKaijoJiyu.toValue(現在の他特の情報.get他市町村住所地特例解除事由コード()).get名称());
            } catch (IllegalArgumentException e) {
                div.getTxtCurrentTatokuKaijoJiyu().setValue(RString.EMPTY);
            }
            div.getTxtCurrentTatokuKaijoYmd().setValue(現在の他特の情報.get解除年月日());
            div.getTxtCurrentTatokuKaijoTodokedeYmd().setValue(現在の他特の情報.get解除届出年月日());
        }
        if (修正後の他特の情報 != null) {
            if (!RString.isNullOrEmpty(修正後の他特の情報.get他市町村住所地特例適用事由コード())) {
                div.getDdlTatokuTekiyoJiyu().setSelectedKey(修正後の他特の情報.get他市町村住所地特例適用事由コード());
            }
            div.getTxtTatokuTekiyoYmd().setValue(修正後の他特の情報.get適用年月日());
            div.getTxtTatokuTekiyoTodokedeYmd().setValue(修正後の他特の情報.get適用届出年月日());
            if (!RString.isNullOrEmpty(修正後の他特の情報.get他市町村住所地特例解除事由コード())) {
                div.getDdlTatokuKaijoJiyu().setSelectedKey(修正後の他特の情報.get他市町村住所地特例解除事由コード());
            }
            div.getTxtTatokuKaijoYmd().setValue(修正後の他特の情報.get解除年月日());
            div.getTxtTatokuKaijoTodokedeYmd().setValue(修正後の他特の情報.get解除届出年月日());
        }
    }

    /**
     * 被保険者の場合、不整合チェック結果（最新の不整合内容）を明細エリアに表示する
     *
     * @param 不整合理由 不整合理由
     * @param 個人情報 個人情報
     * @param 現在の資格の情報 現在の資格の情報
     * @param 修正後の資格の情報 修正後の資格の情報
     * @param 資格取得除外の情報 資格取得除外の情報
     */
    public void setHihokenshaMeisai(FuseigoRiyu 不整合理由, IKojin 個人情報, HihokenshaDaicho 現在の資格の情報,
            HihokenshaDaicho 修正後の資格の情報, ShikakuShutokuJogaisha 資格取得除外の情報) {
        setDdlByHihokensha();
        setDisableHihokensha(不整合理由, 個人情報);
        div.getTxtFusugoNaiyo().setValue(不整合理由.get名称());
        div.getTxtShikibetsuCode().setValue(個人情報.get識別コード().value());
        div.getTxtJuminJotai().setValue(個人情報.get住民状態().住民状態略称());
        div.getTxtSeibetsu().setValue(個人情報.get性別().getCommonName());
        if (個人情報.is日本人()) {
            div.getTxtUmareYmd().setDisplayFormatEnum(DisplayDateFormat.平YYMMDD);
            div.getTxtShimei().setValue(toAppendFullSpace(
                    個人情報.get日本人氏名().getKana().value(), 個人情報.get日本人氏名().getName().value()));
        } else {
            div.getTxtUmareYmd().setDisplayFormatEnum(DisplayDateFormat.YYYYperiodMMperiodDD);
            div.getTxtShimei().setValue(toAppendFullSpace(
                    個人情報.get外国人氏名().getKana().value(), 個人情報.get外国人氏名().getName().value()));
        }
        div.getTxtUmareYmd().setValue(個人情報.get生年月日().toFlexibleDate());
        div.getTxtNenrei().setValue(個人情報.get年齢算出().get年齢());
        div.getTxt1goTotatsuYmd().setValue(個人情報.get年齢算出().get年齢到達日(第１号被保険者到達基準年齢));
        div.getTxtJukiTorokuJiyu().setValue(個人情報.get登録事由().get異動事由略称());
        div.getTxtTorokuIdoYmd().setValue(個人情報.get登録異動年月日());
        div.getTxtTorokuTodokedeYmd().setValue(個人情報.get登録届出年月日());
        div.getTxtJukiShojoJiyu().setValue(個人情報.get消除事由().get異動事由略称());
        div.getTxtShojoIdoYmd().setValue(個人情報.get消除異動年月日());
        div.getTxtShojoTodokedeYmd().setValue(個人情報.get消除届出年月日());
        div.getTxtTenshutsuYoteiYmd().setValue(個人情報.get転出予定().get異動年月日());
        div.getTxtTenshutsuKakuteiYmd().setValue(個人情報.get転出確定().get異動年月日());
        if (現在の資格の情報 != null) {
            try {
                div.getTxtCurrentShikakuShutokuJiyu().setValue(ShikakuShutokuJiyu.toValue(現在の資格の情報.get資格取得事由コード()).get名称());
            } catch (IllegalArgumentException e) {
                div.getTxtCurrentShikakuShutokuJiyu().setValue(RString.EMPTY);
            }
            div.getTxtCurrentShikakuShutokuYmd().setValue(現在の資格の情報.get資格取得年月日());
            div.getTxtCurrentShikakuShutokuTodokedeYmd().setValue(現在の資格の情報.get資格取得届出年月日());
            try {
                div.getTxtCurrentShikakuHenkoJiyu().setValue(ShikakuHenkoJiyu.toValue(現在の資格の情報.get資格変更事由コード()).get名称());
            } catch (IllegalArgumentException e) {
                div.getTxtCurrentShikakuHenkoJiyu().setValue(RString.EMPTY);
            }
            div.getTxtCurrentShikakuHenkoYmd().setValue(現在の資格の情報.get資格変更年月日());
            div.getTxtCurrentShikakuHenkoTodokedeYmd().setValue(現在の資格の情報.get資格変更届出年月日());
            try {
                div.getTxtCurrentJutokuTekiyoJiyu().setValue(ShikakuJutokuTekiyoJiyu.toValue(現在の資格の情報.get住所地特例適用事由コード()).get名称());
            } catch (IllegalArgumentException e) {
                div.getTxtCurrentJutokuTekiyoJiyu().setValue(RString.EMPTY);
            }
            div.getTxtCurrentJutokuTekiyoDate().setValue(現在の資格の情報.get適用年月日());
            div.getTxtCurrentJutokuTekiyoTodokedeDate().setValue(現在の資格の情報.get適用届出年月日());
            try {
                div.getTxtCurrentShikakuSoshitsuJiyu().setValue(ShikakuSoshitsuJiyu.toValue(現在の資格の情報.get資格喪失事由コード()).get名称());
            } catch (IllegalArgumentException e) {
                div.getTxtCurrentShikakuSoshitsuJiyu().setValue(RString.EMPTY);
            }
            div.getTxtCurrentShikakuSoshitsuYmd().setValue(現在の資格の情報.get資格喪失年月日());
            div.getTxtCurrentShikakuSoshitsuTodokedeYmd().setValue(現在の資格の情報.get資格喪失届出年月日());
        }
        if (資格取得除外の情報 != null) {
            div.getTxtShutokuJogaiYmd().setValue(資格取得除外の情報.get資格取得除外年月日());
            div.getTxtShutokuJogaiRiyu().setValue(資格取得除外の情報.get資格取得除外理由());
        }
        if (修正後の資格の情報 != null) {
            div.getTxtHihoNo().setValue(修正後の資格の情報.get被保険者番号().value());
            if (!RString.isNullOrEmpty(修正後の資格の情報.get資格取得事由コード())) {
                div.getDdlShikakuShutokuJiyu().setSelectedKey(修正後の資格の情報.get資格取得事由コード());
            }
            div.getTxtShikakuShutokuYmd().setValue(修正後の資格の情報.get資格取得年月日());
            div.getTxtShikakuShutokuTodokedeYmd().setValue(修正後の資格の情報.get資格取得届出年月日());
            if (!RString.isNullOrEmpty(修正後の資格の情報.get資格変更事由コード())) {
                div.getDdlShikakuHenkoJiyu().setSelectedKey(修正後の資格の情報.get資格変更事由コード());
            }
            div.getTxtShikakuHenkoYmd().setValue(修正後の資格の情報.get資格変更年月日());
            div.getTxtShikakuHenkoTodokedeYmd().setValue(修正後の資格の情報.get資格変更届出年月日());
            if (!RString.isNullOrEmpty(修正後の資格の情報.get住所地特例適用事由コード())) {
                div.getDdlJutokuTekiyoJiyu().setSelectedKey(修正後の資格の情報.get住所地特例適用事由コード());
            }
            div.getTxtJutokuTekiyoDate().setValue(修正後の資格の情報.get適用年月日());
            div.getTxtJutokuTekiyoTodokedeDate().setValue(修正後の資格の情報.get適用届出年月日());
            if (!RString.isNullOrEmpty(修正後の資格の情報.get資格喪失事由コード())) {
                div.getDdlShikakuSoshitsuJiyu().setSelectedKey(修正後の資格の情報.get資格喪失事由コード());
            }
            div.getTxtShikakuSoshitsuYmd().setValue(修正後の資格の情報.get資格喪失年月日());
            div.getTxtShikakuSoshitsuTodokedeYmd().setValue(修正後の資格の情報.get資格喪失届出年月日());
        }
    }

    private void setDisableHihokensha(FuseigoRiyu 不整合理由, IKojin 個人情報) {
        switch (不整合理由) {
            case 資格管理情報未登録者:
                if (div.getChkShutokuJogai().isAllSelected()) {
                    div.getDdlShikakuShutokuJiyu().setDisabled(true);
                    div.getTxtShikakuShutokuTodokedeYmd().setDisabled(true);
                    div.getTxtShikakuShutokuYmd().setDisabled(true);
                } else {
                    div.getTxtShutokuJogaiYmd().setDisabled(true);
                    div.getTxtShutokuJogaiRiyu().setDisabled(true);
                }
                div.getDdlShikakuHenkoJiyu().setDisabled(true);
                div.getTxtShikakuHenkoYmd().setDisabled(true);
                div.getTxtShikakuHenkoTodokedeYmd().setDisabled(true);
                div.getDdlShikakuSoshitsuJiyu().setDisabled(true);
                div.getTxtShikakuSoshitsuYmd().setDisabled(true);
                div.getTxtShikakuSoshitsuTodokedeYmd().setDisabled(true);
                div.getDdlJutokuTekiyoJiyu().setDisabled(true);
                div.getTxtJutokuTekiyoDate().setDisabled(true);
                div.getTxtJutokuTekiyoTodokedeDate().setDisabled(true);
                div.getChkJutoku().setVisible(false);
                break;
            case 資格取得日_転入者:
            case 資格取得日_年齢到達者:
                div.getDdlShikakuShutokuJiyu().setDisabled(true);
                div.getDdlShikakuHenkoJiyu().setDisabled(true);
                div.getTxtShikakuHenkoYmd().setDisabled(true);
                div.getTxtShikakuHenkoTodokedeYmd().setDisabled(true);
                div.getDdlShikakuSoshitsuJiyu().setDisabled(true);
                div.getTxtShikakuSoshitsuYmd().setDisabled(true);
                div.getTxtShikakuSoshitsuTodokedeYmd().setDisabled(true);
                div.getChkJutoku().setVisible(false);
                div.getDdlJutokuTekiyoJiyu().setDisabled(true);
                div.getTxtJutokuTekiyoDate().setDisabled(true);
                div.getTxtJutokuTekiyoTodokedeDate().setDisabled(true);
                div.getChkShutokuJogai().setVisible(false);
                div.getTxtShutokuJogaiYmd().setDisabled(true);
                div.getTxtShutokuJogaiRiyu().setDisabled(true);
                break;
            case 資格取得者_消除者:
            case 資格取得者_死亡者:
            case 資格喪失日_住基不一致:
                div.getDdlShikakuShutokuJiyu().setDisabled(true);
                div.getTxtShikakuShutokuTodokedeYmd().setDisabled(true);
                div.getTxtShikakuShutokuYmd().setDisabled(true);
                div.getDdlShikakuHenkoJiyu().setDisabled(true);
                div.getTxtShikakuHenkoYmd().setDisabled(true);
                div.getTxtShikakuHenkoTodokedeYmd().setDisabled(true);
                div.getDdlShikakuSoshitsuJiyu().setDisabled(true);
                div.getChkJutoku().setVisible(false);
                div.getDdlJutokuTekiyoJiyu().setDisabled(true);
                div.getTxtJutokuTekiyoDate().setDisabled(true);
                div.getTxtJutokuTekiyoTodokedeDate().setDisabled(true);
                div.getChkShutokuJogai().setVisible(false);
                div.getTxtShutokuJogaiYmd().setDisabled(true);
                div.getTxtShutokuJogaiRiyu().setDisabled(true);
                break;
            case 資格取得者_転出者:
            case 資格喪失日_転出予定者:
            case 資格喪失日_転出確定者:
                div.getDdlShikakuShutokuJiyu().setDisabled(true);
                div.getTxtShikakuShutokuTodokedeYmd().setDisabled(true);
                div.getTxtShikakuShutokuYmd().setDisabled(true);
                div.getDdlShikakuHenkoJiyu().setDisabled(true);
                div.getTxtShikakuHenkoYmd().setDisabled(true);
                div.getTxtShikakuHenkoTodokedeYmd().setDisabled(true);
                div.getDdlShikakuSoshitsuJiyu().setDisabled(true);
                if (div.getChkJutoku().isAllSelected()) {
                    div.getTxtShikakuSoshitsuYmd().setDisabled(true);
                    div.getTxtShikakuSoshitsuTodokedeYmd().setDisabled(true);
                } else {
                    div.getDdlJutokuTekiyoJiyu().setDisabled(true);
                    div.getTxtJutokuTekiyoDate().setDisabled(true);
                    div.getTxtJutokuTekiyoTodokedeDate().setDisabled(true);
                }
                div.getChkShutokuJogai().setVisible(false);
                div.getTxtShutokuJogaiYmd().setDisabled(true);
                div.getTxtShutokuJogaiRiyu().setDisabled(true);
                break;
            case 資格変更者_１号被保険者到達:
                div.getDdlShikakuShutokuJiyu().setDisabled(true);
                div.getTxtShikakuShutokuTodokedeYmd().setDisabled(true);
                div.getTxtShikakuShutokuYmd().setDisabled(true);
                div.getDdlShikakuHenkoJiyu().setDisabled(true);
                if (!個人情報.get生年月日().toFlexibleDate().isValid()) {
                    div.getTxtShikakuHenkoYmd().setDisabled(true);
                    div.getTxtShikakuHenkoTodokedeYmd().setDisabled(true);
                }
                div.getDdlShikakuSoshitsuJiyu().setDisabled(true);
                div.getTxtShikakuSoshitsuYmd().setDisabled(true);
                div.getTxtShikakuSoshitsuTodokedeYmd().setDisabled(true);
                div.getChkJutoku().setVisible(false);
                div.getDdlJutokuTekiyoJiyu().setDisabled(true);
                div.getTxtJutokuTekiyoDate().setDisabled(true);
                div.getTxtJutokuTekiyoTodokedeDate().setDisabled(true);
                div.getChkShutokuJogai().setVisible(false);
                div.getTxtShutokuJogaiYmd().setDisabled(true);
                div.getTxtShutokuJogaiRiyu().setDisabled(true);
                break;
            default:
                break;
        }
    }

    private RString toAppendBR(RString beforeBr, RString afterBr) {
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(beforeBr);
        rsb.append(GRID_BR);
        rsb.append(afterBr);
        return rsb.toRString();
    }

    private RString toAppendFullSpace(RString beforeBr, RString afterBr) {
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(beforeBr);
        rsb.append(RString.FULL_SPACE);
        rsb.append(afterBr);
        return rsb.toRString();
    }

    private void setDdlByHihokensha() {
        List<KeyValueDataSource> shutokuList = new ArrayList<>();
        for (ShikakuShutokuJiyu type : ShikakuShutokuJiyu.values()) {
            KeyValueDataSource key = new KeyValueDataSource(type.getコード(), type.get名称());
            shutokuList.add(key);
        }
        div.getDdlShikakuShutokuJiyu().setDataSource(shutokuList);
        List<KeyValueDataSource> henkoList = new ArrayList<>();
        for (ShikakuHenkoJiyu type : ShikakuHenkoJiyu.values()) {
            KeyValueDataSource key = new KeyValueDataSource(type.getコード(), type.get名称());
            henkoList.add(key);
        }
        div.getDdlShikakuHenkoJiyu().setDataSource(henkoList);
        List<KeyValueDataSource> tekiyoJiyuList = new ArrayList<>();
        for (ShikakuJutokuTekiyoJiyu type : ShikakuJutokuTekiyoJiyu.values()) {
            KeyValueDataSource key = new KeyValueDataSource(type.getコード(), type.get名称());
            tekiyoJiyuList.add(key);
        }
        div.getDdlJutokuTekiyoJiyu().setDataSource(tekiyoJiyuList);
        List<KeyValueDataSource> soshitsuList = new ArrayList<>();
        for (ShikakuSoshitsuJiyu type : ShikakuSoshitsuJiyu.values()) {
            KeyValueDataSource key = new KeyValueDataSource(type.getコード(), type.get名称());
            soshitsuList.add(key);
        }
        div.getDdlShikakuSoshitsuJiyu().setDataSource(soshitsuList);
    }

    private void setDdlByTekiyo() {
        List<KeyValueDataSource> tekiyoList = new ArrayList<>();
        for (JogaiTekiyoJiyu type : JogaiTekiyoJiyu.values()) {
            KeyValueDataSource key = new KeyValueDataSource(type.getコード(), type.get名称());
            tekiyoList.add(key);
        }
        div.getDdlTekiyoJogaiTekiyoJiyu().setDataSource(tekiyoList);
        List<KeyValueDataSource> kaijoList = new ArrayList<>();
        for (JogaiKaijoJiyu type : JogaiKaijoJiyu.values()) {
            KeyValueDataSource key = new KeyValueDataSource(type.getコード(), type.get名称());
            kaijoList.add(key);
        }
        div.getDdlTekiyoJogaiKaijoJiyu().setDataSource(kaijoList);
    }

    private void setDdlByTashichoson() {
        List<KeyValueDataSource> tekiyoList = new ArrayList<>();
        for (TatokureiTekiyoJiyu type : TatokureiTekiyoJiyu.values()) {
            KeyValueDataSource key = new KeyValueDataSource(type.getコード(), type.get名称());
            tekiyoList.add(key);
        }
        div.getDdlTatokuTekiyoJiyu().setDataSource(tekiyoList);
        List<KeyValueDataSource> kaijoList = new ArrayList<>();
        for (TatokureiKaijoJiyu type : TatokureiKaijoJiyu.values()) {
            KeyValueDataSource key = new KeyValueDataSource(type.getコード(), type.get名称());
            kaijoList.add(key);
        }
        div.getDdlTatokuKaijoJiyu().setDataSource(kaijoList);
    }

    private RString rdateToRstr(RDateTime 処理日時) {
        if (処理日時 == null) {
            return RString.EMPTY;
        }
        RStringBuilder 日時 = new RStringBuilder();
        日時.append(処理日時.getDate().wareki().toDateString());
        日時.append(new RString(" "));
        日時.append(処理日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        return 日時.toRString();
    }
}
