/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0080011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.soufujouhou.SoufuJouhouBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0080011.SoufuJouhouDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0080011.dgSofuIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 画面設計_DBC0080011_再審査申立送付情報照会のHandlerです。
 *
 * @reamsid_L DBC-3050-010 zhangzhiming
 */
public class SoufuJouhouHandler {

    private final SoufuJouhouDiv div;
    private static final RString 広域 = new RString("111");
    private static final RString 市町村識別ID_00 = new RString("00");
    private static final RString 市町村識別ID_01 = new RString("01");
    private static final RString 市町村識別ID_99 = new RString("99");
    private static final RString キー = new RString("000000");
    private static final int 連番_4 = 4;

    /**
     * 再審査申立送付情報照会のHandlerです。
     *
     * @param div SoufuJouhouDiv
     */
    public SoufuJouhouHandler(SoufuJouhouDiv div) {
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
        if (広域.equals(市町村情報.get導入形態コード().value())) {
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
            if (!市町村識別ID.isEmpty() && (市町村識別ID_01.equals(市町村識別ID.get(0).getItemId())
                    || 市町村識別ID_99.equals(市町村識別ID.get(0).getItemId()))) {
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
     * 再審査申立決定情報照会を初期化です。
     *
     * @param 再審査申立書情報Business 再審査申立書情報
     */
    public void onClick_btnSofuzumi(List<SoufuJouhouBusiness> 再審査申立書情報Business) {
        List<dgSofuIchiran_Row> list = new ArrayList<>();
        for (SoufuJouhouBusiness business : 再審査申立書情報Business) {
            dgSofuIchiran_Row row = new dgSofuIchiran_Row();
            row.setTxtJigyoshaNo(business.get事業所番号());
            row.setTxtHihoName(business.get事業所名());
            row.setTxtHihoNo(business.get被保険者番号());
            row.setTxtHihoName(business.get宛名名称());
            row.setTxtServiceTeikyoYM(new FlexibleDate(business.getサービス提供年月()).getYearMonth().wareki().toDateString());
            row.setTxtServiceShuruiCode(business.getサービス種類コード());
            row.setTxtServiceKoumokuCode(business.getサービス項目コード());
            row.setTxtServiceName(business.getサービス略称());
            row.setTxtShokisaiHokenshaNo(business.get証記載保険者番号());
            row.setTxtMoshitateYMD(new FlexibleDate(business.get申立年月日()).wareki().toDateString());
            row.setTxtMoshitateshaKubun(business.get申立者区分コード());
            row.setTxtMoshitateTani(business.get申立単位数());
            row.setTxtMoshitateRiyu1(business.get申立事由コード().substring(0, 2).concat(CodeMaster.getCodeRyakusho(SubGyomuCode.DBC介護給付,
                    DBCCodeShubetsu.再審査決定申立事由コード_上２桁_申立対象項目コード.getコード(), new Code("0021"), FlexibleDate.getNowDate())));
            row.setTxtMoshitateRiyu2(business.get申立事由コード().substring(2, 連番_4).concat(CodeMaster.getCodeRyakusho(SubGyomuCode.DBC介護給付,
                    DBCCodeShubetsu.再審査決定申立事由コード_下２桁_申立理由番号.getコード(),
                    new Code("0022"), FlexibleDate.getNowDate())));
            list.add(row);
            アクセスログ(business.get被保険者番号());
        }
        div.getDgSofuIchiran().setDataSource(list);
    }

    /**
     * アクセスログを出力です。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void アクセスログ(RString 被保険者番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(被保険者番号));
    }

    private PersonalData toPersonalData(RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }
}
