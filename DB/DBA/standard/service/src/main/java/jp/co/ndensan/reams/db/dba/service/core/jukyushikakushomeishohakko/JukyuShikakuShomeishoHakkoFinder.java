/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.jukyushikakushomeishohakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.jukyushikakushomeishohakko.JukyuShikakuShomeishoModel;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.JuKyuShinSeiZiYu;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.config.ConfigKeysJukyuShikakuShomeishoHakko;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.core.YukoMukoKubun;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.jukyushikakushomeishohakko.JukyuShikakuShomeishoHakkoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.JukyuShikakuShomeishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.jukyushikakushomeishohakko.IJukyuShikakuShomeishoHakkoRelateMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保険者証・資格者証発行を管理するクラスです。
 *
 */
public class JukyuShikakuShomeishoHakkoFinder {

    private static final RString SPACE = new RString("　");
    private static final RString SAKAKO = new RString("（");
    private static final RString MIGIKAKO = new RString("）");
    private static final RString MATAHA = new RString("までは");
    private static final RString 読点 = new RString("、");
    private static final int FIRST_INDEX = 0;
    private static final int LENGTH_150 = 150;
    private static final int LENGTH_240 = 240;

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタ。
     *
     */
    public JukyuShikakuShomeishoHakkoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JukyuShikakuShomeishoHakkoFinder} のインスタンスを返します。
     *
     * @return JukyuShikakuShomeishoHakkoFinder
     */
    public static JukyuShikakuShomeishoHakkoFinder createInstance() {
        return InstanceProvider.create(JukyuShikakuShomeishoHakkoFinder.class);
    }

    /**
     * 被保険者番号をキーに受給者台帳テーブル、要介護認定結果情報テーブルと宛名識別対象PSMからデータを取得します。
     *
     * @param 受給資格証明書発行情報の検索キー 受給資格証明書発行情報の検索キー。
     *
     * １、受給資格証明書発行情報を取得できない場合、NULLを返します。 ２、「受給者台帳」テーブルに、認定申請中データ．受給申請事由がDBD.Enum受給申請事由.指定サービス種類変更申請である場合、 NULLを返します。
     * ３、受給資格証明書発行情報を取得して、被保険者証・資格者証発行を表すクラスを返します。
     * @return JukyuShikakuShomeisho 被保険者証・資格者証発行の表すクラスを返します。
     */
    public JukyuShikakuShomeishoModel getJukyuShikakuShomeishoHakko(JukyuShikakuShomeishoHakkoParameter 受給資格証明書発行情報の検索キー) {
        IJukyuShikakuShomeishoHakkoRelateMapper jukyuShikakuShomeishoHakko = mapperProvider.
                create(IJukyuShikakuShomeishoHakkoRelateMapper.class);
        JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRe = jukyuShikakuShomeishoHakko
                .getJukyuShikakuShomeishoHakko(受給資格証明書発行情報の検索キー);
        if (jukyuShikakuShomeishoHakkoRe == null) {
            return null;
        }
        JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoCode = jukyuShikakuShomeishoHakko
                .getServiceCode(受給資格証明書発行情報の検索キー);
        get種類名称と種類略称(jukyuShikakuShomeishoHakkoRe,
                jukyuShikakuShomeishoHakkoCode, jukyuShikakuShomeishoHakko);
        JukyuShikakuShomeishoHakkoRelateEntity ninTeiShinSeiChuDataEntity = jukyuShikakuShomeishoHakko
                .getNinTeiShinSeiChuData(受給資格証明書発行情報の検索キー);
        if (ninTeiShinSeiChuDataEntity == null) {
            if (new FlexibleDate(jukyuShikakuShomeishoHakkoRe.getNinteiYukoKikanKaishiYMD())
                    .isBefore(new FlexibleDate(get制度改正施行管理_新予防給付_適用開始日()))) {
                jukyuShikakuShomeishoHakkoRe.setBiko(get受給資格証明書_備考項目文言());
            } else {
                jukyuShikakuShomeishoHakkoRe.setBiko(RString.EMPTY);
            }
            jukyuShikakuShomeishoHakkoRe.setJukyuShinseiYMD(RString.EMPTY);
        } else {
            jukyuShikakuShomeishoHakkoRe = edit備考(jukyuShikakuShomeishoHakkoRe,
                    ninTeiShinSeiChuDataEntity, jukyuShikakuShomeishoHakko);
        }
        if (jukyuShikakuShomeishoHakkoRe == null) {
            return null;
        }
        return new JukyuShikakuShomeishoModel(jukyuShikakuShomeishoHakkoRe);
    }

    private void get種類名称と種類略称(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRe,
            JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoCode,
            IJukyuShikakuShomeishoHakkoRelateMapper jukyuShikakuShomeishoHakko) {

        List<RString> サービス種類コードリスト = サービス種類コードリストを設定します(jukyuShikakuShomeishoHakkoCode);
        List<RString> サービス種類名称リスト = new ArrayList<>();
        List<RString> サービス種類略称リスト = new ArrayList<>();
        for (RString code : サービス種類コードリスト) {
            if (code == null || code.isEmpty()) {
                continue;
            }
            JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoTemp = jukyuShikakuShomeishoHakko
                    .getServiceMei(JukyuShikakuShomeishoHakkoParameter
                            .createSelectByサービス種類コード(code.trimEnd(), YukoMukoKubun.有効.getコード()));
            if (jukyuShikakuShomeishoHakkoTemp == null) {
                continue;
            }
            サービス種類名称リスト.add(jukyuShikakuShomeishoHakkoTemp.getServiceShuruiMeisho());
            サービス種類略称リスト.add(jukyuShikakuShomeishoHakkoTemp.getServiceShuruiRyakusho());
        }
        edit介護認定審査会意見(jukyuShikakuShomeishoHakkoRe, サービス種類名称リスト, サービス種類略称リスト);
    }

    private List<RString> サービス種類コードリストを設定します(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRe) {
        List<RString> サービス種類コードList = new ArrayList<>();
        if (jukyuShikakuShomeishoHakkoRe == null) {
            return サービス種類コードList;
        }
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui01());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui02());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui03());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui04());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui05());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui06());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui07());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui08());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui09());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui10());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui11());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui12());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui13());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui14());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui15());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui16());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui17());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui18());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui19());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui20());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui21());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui22());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui23());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui24());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui25());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui26());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui27());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui28());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui29());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRe.getShiteiServiceShurui30());

        return サービス種類コードList;
    }

    private void edit介護認定審査会意見(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRe,
            List<RString> サービス種類名称リスト, List<RString> サービス種類略称リスト) {
        RStringBuilder 介護認定審査会意見と名称 = new RStringBuilder(jukyuShikakuShomeishoHakkoRe.getShinsakaiIken());
        介護認定審査会意見と名称.append(SPACE);
        介護認定審査会意見と名称.append(サービス種類名称リスト.get(FIRST_INDEX));
        for (int i = 1; i < サービス種類名称リスト.size(); i++) {
            if (サービス種類名称リスト.get(i) != null && !サービス種類名称リスト.get(i).trim().isEmpty()) {
                介護認定審査会意見と名称.append(読点);
                介護認定審査会意見と名称.append(サービス種類名称リスト.get(i));
            }
        }
        RStringBuilder 介護認定審査会意見と略称 = new RStringBuilder(jukyuShikakuShomeishoHakkoRe.getShinsakaiIken());
        介護認定審査会意見と略称.append(SPACE);
        介護認定審査会意見と略称.append(サービス種類略称リスト.get(FIRST_INDEX));
        for (int j = 1; j < サービス種類略称リスト.size(); j++) {
            if (サービス種類略称リスト.get(j) != null && !サービス種類略称リスト.get(j).trim().isEmpty()) {
                介護認定審査会意見と略称.append(読点);
                介護認定審査会意見と略称.append(サービス種類略称リスト.get(j));
            }
        }
        if (介護認定審査会意見と名称.toRString().length() <= LENGTH_150) {
            jukyuShikakuShomeishoHakkoRe.setShinsakaiIken(介護認定審査会意見と名称.toRString());
        } else if (介護認定審査会意見と略称.toRString().length() <= LENGTH_150) {
            jukyuShikakuShomeishoHakkoRe.setShinsakaiIken(介護認定審査会意見と略称.toRString());
        } else {
            jukyuShikakuShomeishoHakkoRe.setShinsakaiIken(介護認定審査会意見と略称.substring(0, LENGTH_150));
        }
    }

    private JukyuShikakuShomeishoHakkoRelateEntity edit備考(
            JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRe,
            JukyuShikakuShomeishoHakkoRelateEntity ninTeiShinSeiChuDataEntity,
            IJukyuShikakuShomeishoHakkoRelateMapper jukyuShikakuShomeishoHakko) {

        JukyuShikakuShomeishoHakkoRelateEntity ninTeiChouSaJouEntity = jukyuShikakuShomeishoHakko
                .getNinTeiChouSaJou(JukyuShikakuShomeishoHakkoParameter.
                        createSelectBy申請書管理番号(ninTeiShinSeiChuDataEntity.getShinseishoKanriNo()));
        RStringBuilder workBiko = new RStringBuilder(RString.EMPTY);
         // TODO 汪坤 QA38 DBD.Enum受給申請事由とDBD.Enum受給資格証明書申請種類文言のクラスが未提供ですので、
        // とりあえず全てJuKyuShinSeiZiYuで仮定義しています
        RString jukyuShinseiJiyu = ninTeiShinSeiChuDataEntity.getJukyuShinseiJiyu();
        if (JuKyuShinSeiZiYu.初回申請.getCode().equals(jukyuShinseiJiyu)
                || JuKyuShinSeiZiYu.再申請_有効期限外.getCode().equals(jukyuShinseiJiyu)
                || JuKyuShinSeiZiYu.要介護度変更申請.getCode().equals(jukyuShinseiJiyu)
                || JuKyuShinSeiZiYu.申請_法施行前.getCode().equals(jukyuShinseiJiyu)) {
            if (JuKyuShinSeiZiYu.要介護度変更申請.getCode().equals(jukyuShinseiJiyu)
                    && !ninTeiShinSeiChuDataEntity.getYoshienshaNinteiShinseiFlag()) {
                workBiko = workBiko.append(JuKyuShinSeiZiYu.区分変更申請中で_認定調査.getCode());
            } else {
                workBiko = workBiko.append(JuKyuShinSeiZiYu.要介護認定申請中で_認定審査.getCode());
            }
            if (ninTeiChouSaJouEntity == null) {
                workBiko = workBiko.append(JuKyuShinSeiZiYu.未.getCode());
            } else {
                if (ninTeiChouSaJouEntity.getNinteichosaJisshiYMD() != null
                        && !ninTeiChouSaJouEntity.getNinteichosaJisshiYMD().isEmpty()) {
                    workBiko = workBiko.append(JuKyuShinSeiZiYu.済.getCode());
                } else {
                    workBiko = workBiko.append(JuKyuShinSeiZiYu.未.getCode());
                }
            }
        }
        if (JuKyuShinSeiZiYu.再申請_有効期限内.getCode().equals(jukyuShinseiJiyu)) {
            workBiko = workBiko.append(JuKyuShinSeiZiYu.更新認定申請中で_認定結果未.getCode());
            workBiko = workBiko.append(SAKAKO)
                    .append(new FlexibleDate(jukyuShikakuShomeishoHakkoRe.getNinteiYukoKikanShuryoYMD()).wareki()
                            .toDateString())
                    .append(MATAHA)
                    .append(YokaigoJotaiKubun09.toValue(jukyuShikakuShomeishoHakkoRe.getYokaigoJotaiKubunCode())
                            .getName())
                    .append(MIGIKAKO);
        }
        if (JuKyuShinSeiZiYu.指定サービス種類変更申請.getCode()
                .equals(jukyuShinseiJiyu)) {
            return null;
        }
        if (new FlexibleDate(jukyuShikakuShomeishoHakkoRe.getNinteiYukoKikanKaishiYMD())
                .isBefore(new FlexibleDate(get制度改正施行管理_新予防給付_適用開始日()))) {
            workBiko.append(get受給資格証明書_備考項目文言());
        }
        if (workBiko.length() <= LENGTH_240) {
            jukyuShikakuShomeishoHakkoRe.setBiko(workBiko.toRString());
        } else {
            jukyuShikakuShomeishoHakkoRe.setBiko(workBiko.toRString().substring(0, LENGTH_240));
        }
        return jukyuShikakuShomeishoHakkoRe;
    }

    private RString get制度改正施行管理_新予防給付_適用開始日() {
        return BusinessConfig.get(ConfigKeysJukyuShikakuShomeishoHakko.制度改正施行管理_新予防給付_適用開始日, SubGyomuCode.DBU介護統計報告);
    }

    private RString get受給資格証明書_備考項目文言() {
        return BusinessConfig.get(ConfigKeysJukyuShikakuShomeishoHakko.受給資格証明書_備考項目文言, SubGyomuCode.DBD介護受給);
    }
}
