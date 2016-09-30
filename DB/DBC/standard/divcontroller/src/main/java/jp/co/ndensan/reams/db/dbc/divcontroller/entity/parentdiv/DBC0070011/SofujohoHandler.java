/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0070011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbc.business.core.sofujoho.SofujohoBusiness;
import jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate.KagoMoshitate_MoshitateshoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 過誤申立送付情報照会のHandlerです。
 *
 * @reamsid_L DBC-2950-010 jinjue
 */
public class SofujohoHandler {

    private final SofujohoDiv div;
    private static final RString 市町村識別ID_00 = new RString("00");
    private static final RString キー = new RString("000000");
    private static final int 連番_4 = 4;
    private static final RString 申立書区分_1 = new RString("1");
    private static final RString 申立書区分_2 = new RString("2");
    private static final RString 申立書区分_3 = new RString("3");

    /**
     * 過誤申立送付情報照会のHandlerです。
     *
     * @param div SofujohoDiv
     */
    public SofujohoHandler(SofujohoDiv div) {
        this.div = div;
    }

    /**
     * 再審査申立決定情報照会を初期化です。
     *
     * @param 市町村情報 市町村情報
     * @param 市町村識別ID 市町村識別ID
     * @param 構成市町村 構成市町村
     */
    public void onLoad(ShichosonSecurityJoho 市町村情報, List<AuthorityItem> 市町村識別ID, List<KoikiZenShichosonJoho> 構成市町村) {
        List<KeyValueDataSource> list = new ArrayList<>();
        List<dgSofuIchiran_Row> listdatesource = new ArrayList<>();
        div.getDgSofuIchiran().setDataSource(listdatesource);
        if (DonyuKeitaiCode.事務広域.getCode().equals(市町村情報.get導入形態コード().value())) {
            div.getDdlShichosonName().setDisplayNone(false);
            div.getDdlShichosonName().setVisible(true);
            if (!市町村識別ID.isEmpty() && 市町村識別ID_00.equals(市町村識別ID.get(0).getItemId())) {
                KeyValueDataSource keyValue = new KeyValueDataSource();
                keyValue.setKey(キー);
                keyValue.setValue(new RString("000000 全市町村"));
                list.add(keyValue);
                for (KoikiZenShichosonJoho koikiZen : 構成市町村) {
                    KeyValueDataSource key = new KeyValueDataSource();
                    RStringBuilder builder = new RStringBuilder();
                    builder.append(koikiZen.get市町村コード().value());
                    builder.append(RString.HALF_SPACE);
                    builder.append(koikiZen.get市町村名称());
                    key.setKey(koikiZen.get市町村コード().value());
                    key.setValue(builder.toRString());
                    list.add(key);
                }
            }
            if (!市町村識別ID.isEmpty() && !市町村識別ID_00.equals(市町村識別ID.get(0).getItemId())) {
                KeyValueDataSource key = new KeyValueDataSource();
                RStringBuilder builder = new RStringBuilder();
                builder.append(市町村情報.get市町村情報().get市町村コード().value());
                builder.append(RString.HALF_SPACE);
                builder.append(市町村情報.get市町村情報().get市町村名称());
                key.setKey(市町村情報.get市町村情報().get市町村コード().value());
                key.setValue(builder.toRString());
                list.add(key);
            }
        }
        div.getTxtSofuYM().setValue(new RDate(RDate.getNowDate().getYearMonth().toString()));
        div.getDdlShichosonName().setDataSource(list);
        if (!list.isEmpty()) {
            div.getDdlShichosonName().setSelectedKey(list.get(0).getKey());
        }
    }

    /**
     * 過誤申立送付情報照会を取得です。
     *
     * @param 過誤申立書情報 過誤申立書情報
     * @param 経過措置 経過措置
     * @param 総合事業費過誤申立書情報 総合事業費過誤申立書情報
     *
     * @return 過誤申立送付情報照会
     */
    public List<SofujohoBusiness> onClick_btnSearch(List<SofujohoBusiness> 過誤申立書情報,
            List<SofujohoBusiness> 経過措置, List<SofujohoBusiness> 総合事業費過誤申立書情報) {
        List<SofujohoBusiness> 過誤送付情報 = new ArrayList<>();
        if (!過誤申立書情報.isEmpty()) {
            get過誤送付情報(過誤申立書情報, 申立書区分_1);
            過誤送付情報 = 過誤申立書情報;
        }
        if (過誤申立書情報.isEmpty() && !経過措置.isEmpty()) {
            get過誤送付情報(経過措置, 申立書区分_2);
            過誤送付情報 = 経過措置;
        }
        if (過誤申立書情報.isEmpty() && 経過措置.isEmpty() && !総合事業費過誤申立書情報.isEmpty()) {
            get過誤送付情報(総合事業費過誤申立書情報, 申立書区分_3);
            過誤送付情報 = 総合事業費過誤申立書情報;
        }
        return 過誤送付情報;
    }

    /**
     * 過誤申立送付情報照会を取得です。
     *
     * @param 過誤申立送付情報照会 過誤申立送付情報照会
     * @param 申立書区分 申立書区分
     *
     * @return 過誤申立送付情報照会
     */
    public List<SofujohoBusiness> onClick_btnSearch再(List<SofujohoBusiness> 過誤申立送付情報照会, RString 申立書区分) {
        get過誤送付情報(過誤申立送付情報照会, 申立書区分);
        return 過誤申立送付情報照会;
    }

    /**
     * アクセスログを出力です。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void アクセスログ(RString 被保険者番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(被保険者番号));
    }

    private void get過誤送付情報(List<SofujohoBusiness> 過誤送付情報, RString 申立書区分) {
        List<dgSofuIchiran_Row> rowList = new ArrayList<>();
        if (申立書区分_1.equals(申立書区分)) {
            for (SofujohoBusiness 送付情報 : 過誤送付情報) {
                dgSofuIchiran_Row row = new dgSofuIchiran_Row();
                row.setTxtJigyoshaNo(送付情報.get事業所番号());
                row.setTxtJigyoshaName(送付情報.get事業所名());
                row.setTxtHihoNo(送付情報.get被保険者番号());
                row.setTxtHihoName(送付情報.get宛名名称());
                row.setTxtMoshitateshaKubun(KagoMoshitate_MoshitateshoKubun.toValue(送付情報.get申立者区分コード()).get名称());
                row.setTxtStyle(送付情報.get申立事由コード().substring(0, 2).concat(CodeMaster.getCodeRyakusho(SubGyomuCode.DBC介護給付,
                        DBCCodeShubetsu.過誤申立事由_上２桁_様式番号.getコード(), new Code(送付情報.get申立事由コード().substring(0, 2)), FlexibleDate.getNowDate())));
                row.setTxtMoshitateRiyu(送付情報.get申立事由コード().substring(2, 連番_4).concat(CodeMaster.getCodeRyakusho(SubGyomuCode.DBC介護給付,
                        DBCCodeShubetsu.過誤申立事由コード_下２桁_申立理由.getコード(),
                        new Code(送付情報.get申立事由コード().substring(2, 連番_4)), FlexibleDate.getNowDate())));
                row.setTxtServiceTeikyoYM(送付情報.getサービス提供年月().wareki().toDateString());
                row.setTxtMoshitateYMD(送付情報.get申立年月日().wareki().toDateString());
                row.setTxtShokisaiHokenshaNo(送付情報.get証記載保険者番号());
                rowList.add(row);
                アクセスログ(送付情報.get被保険者番号());
            }
        }
        if (申立書区分_2.equals(申立書区分)) {
            for (SofujohoBusiness 送付情報 : 過誤送付情報) {
                dgSofuIchiran_Row row = new dgSofuIchiran_Row();
                row.setTxtJigyoshaNo(送付情報.get事業所番号());
                row.setTxtJigyoshaName(送付情報.get事業所名());
                row.setTxtHihoNo(送付情報.get被保険者番号());
                row.setTxtHihoName(送付情報.get宛名名称());
                row.setTxtMoshitateshaKubun(KagoMoshitate_MoshitateshoKubun.toValue(送付情報.get申立者区分コード()).get名称());
                row.setTxtStyle(送付情報.get申立事由コード().substring(0, 2).concat(CodeMaster.getCodeRyakusho(SubGyomuCode.DBC介護給付,
                        DBCCodeShubetsu.総合事業_経過措置_過誤申立事由_様式_.getコード(), new Code(送付情報.get申立事由コード().substring(0, 2)), FlexibleDate.getNowDate())));
                row.setTxtMoshitateRiyu(送付情報.get申立事由コード().substring(2, 連番_4).concat(CodeMaster.getCodeRyakusho(SubGyomuCode.DBC介護給付,
                        DBCCodeShubetsu.総合事業_経過措置_過誤申立理由_理由.getコード(),
                        new Code(送付情報.get申立事由コード().substring(2, 連番_4)), FlexibleDate.getNowDate())));
                row.setTxtServiceTeikyoYM(送付情報.getサービス提供年月().wareki().toDateString());
                row.setTxtMoshitateYMD(送付情報.get申立年月日().wareki().toDateString());
                row.setTxtShokisaiHokenshaNo(送付情報.get証記載保険者番号());
                rowList.add(row);
                アクセスログ(送付情報.get被保険者番号());
            }
        }
        if (申立書区分_3.equals(申立書区分)) {
            for (SofujohoBusiness 送付情報 : 過誤送付情報) {
                dgSofuIchiran_Row row = new dgSofuIchiran_Row();
                row.setTxtJigyoshaNo(送付情報.get事業所番号());
                row.setTxtJigyoshaName(送付情報.get事業所名());
                row.setTxtHihoNo(送付情報.get被保険者番号());
                row.setTxtHihoName(送付情報.get宛名名称());
                row.setTxtMoshitateshaKubun(KagoMoshitate_MoshitateshoKubun.toValue(送付情報.get申立者区分コード()).get名称());
                row.setTxtStyle(送付情報.get申立事由コード().substring(0, 2).concat(CodeMaster.getCodeRyakusho(SubGyomuCode.DBC介護給付,
                        DBCCodeShubetsu.総合事業過誤申立事由_様式.getコード(), new Code(送付情報.get申立事由コード().substring(0, 2)), FlexibleDate.getNowDate())));
                row.setTxtMoshitateRiyu(送付情報.get申立事由コード().substring(2, 連番_4).concat(CodeMaster.getCodeRyakusho(SubGyomuCode.DBC介護給付,
                        DBCCodeShubetsu.総合事業過誤申立事由_理由.getコード(),
                        new Code(送付情報.get申立事由コード().substring(2, 連番_4)), FlexibleDate.getNowDate())));
                row.setTxtServiceTeikyoYM(送付情報.getサービス提供年月().wareki().toDateString());
                row.setTxtMoshitateYMD(送付情報.get申立年月日().wareki().toDateString());
                row.setTxtShokisaiHokenshaNo(送付情報.get証記載保険者番号());
                rowList.add(row);
                アクセスログ(送付情報.get被保険者番号());
            }
        }
        div.getDgSofuIchiran().setDataSource(rowList);
    }

    private PersonalData toPersonalData(RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }
}
