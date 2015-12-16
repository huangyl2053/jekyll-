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
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.jukyushikakushomeishohakko.JukyuShikakuShomeishoHakkoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.JukyuShikakuShomeishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.jukyushikakushomeishohakko.IJukyuShikakuShomeishoHakkoRelateMapper;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.YukoMukoKubun;
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

    public static final RString SPACE = new RString("　");
    public static final RString SAKAKO = new RString("（");
    public static final RString MIGIKAKO = new RString("）");
    public static final RString MATAHA = new RString("までは");
    public static final RString 読点 = new RString("、");
    public static final int FIRST_INDEX = 0;
    public static final int LENGTH_150 = 150;
    public static final int LENGTH_240 = 240;

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
     * １、受給資格証明書発行情報を取得できない場合、NULLを返します。
     * ２、「受給者台帳」テーブルに、認定申請中データ．受給申請事由がDBD.Enum受給申請事由.指定サービス種類変更申請である場合、
     *      NULLを返します。
     * ３、受給資格証明書発行情報を取得して、被保険者証・資格者証発行を表すクラスを返します。
     * @return JukyuShikakuShomeisho 被保険者証・資格者証発行の表すクラスを返します。
     */
    public JukyuShikakuShomeishoModel getJukyuShikakuShomeishoHakko(JukyuShikakuShomeishoHakkoParameter
            受給資格証明書発行情報の検索キー) {
        IJukyuShikakuShomeishoHakkoRelateMapper jukyuShikakuShomeishoHakkoMapper = mapperProvider.
                create(IJukyuShikakuShomeishoHakkoRelateMapper.class);
        JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRelateEntity = jukyuShikakuShomeishoHakkoMapper
                .getJukyuShikakuShomeishoHakko(受給資格証明書発行情報の検索キー);
        if (jukyuShikakuShomeishoHakkoRelateEntity == null) {
            return null;
        }
        JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoCode = jukyuShikakuShomeishoHakkoMapper
                .getServiceCode(受給資格証明書発行情報の検索キー);
        get種類名称と種類略称(jukyuShikakuShomeishoHakkoRelateEntity,
                jukyuShikakuShomeishoHakkoCode, jukyuShikakuShomeishoHakkoMapper);
        JukyuShikakuShomeishoHakkoRelateEntity ninTeiShinSeiChuDataEntity = jukyuShikakuShomeishoHakkoMapper
                .getNinTeiShinSeiChuData(受給資格証明書発行情報の検索キー);
        if (ninTeiShinSeiChuDataEntity == null) {
            if (new FlexibleDate(jukyuShikakuShomeishoHakkoRelateEntity.getNinteiYukoKikanKaishiYMD())
                    .isBefore(new FlexibleDate(get制度改正施行管理_新予防給付_適用開始日()))) {
                jukyuShikakuShomeishoHakkoRelateEntity.setBiko(get受給資格証明書_備考項目文言());
            } else {
                jukyuShikakuShomeishoHakkoRelateEntity.setBiko(RString.EMPTY);
            }
            jukyuShikakuShomeishoHakkoRelateEntity.setJukyuShinseiYMD(RString.EMPTY);
        } else {
            jukyuShikakuShomeishoHakkoRelateEntity = edit備考(jukyuShikakuShomeishoHakkoRelateEntity, 
                    ninTeiShinSeiChuDataEntity, jukyuShikakuShomeishoHakkoMapper);
        }
        if (jukyuShikakuShomeishoHakkoRelateEntity == null) {
             return null;
        }
        return new JukyuShikakuShomeishoModel(jukyuShikakuShomeishoHakkoRelateEntity);
    }

    private void get種類名称と種類略称(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRelateEntity,
            JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoCode,
            IJukyuShikakuShomeishoHakkoRelateMapper jukyuShikakuShomeishoHakkoMapper) {

        List<RString> サービス種類コードリスト = サービス種類コードリストを設定します(jukyuShikakuShomeishoHakkoCode);
        List<RString> サービス種類名称リスト = new ArrayList<>();
        List<RString> サービス種類略称リスト = new ArrayList<>();
        for (RString code : サービス種類コードリスト) {
            if (code == null || code.isEmpty() ) {
                break;
            } 
            JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoTemp = jukyuShikakuShomeishoHakkoMapper
                        .getServiceMei(JukyuShikakuShomeishoHakkoParameter
                                .createSelectByサービス種類コード(code.trimEnd(),YukoMukoKubun.有効.getコード()));
            if (jukyuShikakuShomeishoHakkoTemp != null) {
                サービス種類名称リスト.add(jukyuShikakuShomeishoHakkoTemp.getServiceShuruiMeisho());
                サービス種類略称リスト.add(jukyuShikakuShomeishoHakkoTemp.getServiceShuruiRyakusho());
            } else {
                サービス種類名称リスト.add(RString.EMPTY);
                サービス種類略称リスト.add(RString.EMPTY);
            }
        }
        edit介護認定審査会意見(jukyuShikakuShomeishoHakkoRelateEntity, サービス種類名称リスト, サービス種類略称リスト);
    }

    private List<RString> サービス種類コードリストを設定します(JukyuShikakuShomeishoHakkoRelateEntity 
            jukyuShikakuShomeishoHakkoRelateEntity) {
        List<RString> サービス種類コードList = new ArrayList<>();
        if (jukyuShikakuShomeishoHakkoRelateEntity == null) {
            return サービス種類コードList;
        }
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui01());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui02());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui03());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui04());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui05());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui06());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui07());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui08());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui09());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui10());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui11());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui12());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui13());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui14());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui15());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui16());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui17());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui18());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui19());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui20());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui21());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui22());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui23());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui24());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui25());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui26());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui27());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui28());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui29());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelateEntity.getShiteiServiceShurui30());

        return サービス種類コードList;
    }

    private void edit介護認定審査会意見(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRelate,
            List<RString> サービス種類名称リスト, List<RString> サービス種類略称リスト) {
        RStringBuilder 介護認定審査会意見と名称 = new RStringBuilder(jukyuShikakuShomeishoHakkoRelate.getShinsakaiIken());
        介護認定審査会意見と名称.append(SPACE);
        介護認定審査会意見と名称.append(サービス種類名称リスト.get(FIRST_INDEX));
        for (int i =1; i < サービス種類名称リスト.size(); i++) {
            if( サービス種類名称リスト.get(i)  != null &&! サービス種類名称リスト.get(i).trim().isEmpty()) {
                介護認定審査会意見と名称.append(読点);
                介護認定審査会意見と名称.append(サービス種類名称リスト.get(i));
            }
        }
        RStringBuilder 介護認定審査会意見と略称 = new RStringBuilder(jukyuShikakuShomeishoHakkoRelate.getShinsakaiIken());
        介護認定審査会意見と略称.append(SPACE);
        介護認定審査会意見と略称.append(サービス種類略称リスト.get(FIRST_INDEX));
        for (int j =1; j < サービス種類略称リスト.size(); j++) {
            if(サービス種類略称リスト.get(j) != null && !サービス種類略称リスト.get(j).trim().isEmpty()) {
                介護認定審査会意見と略称.append(読点);
                介護認定審査会意見と略称.append(サービス種類略称リスト.get(j));
             }
        }
        if (介護認定審査会意見と名称.toRString().length() <= LENGTH_150) {
            jukyuShikakuShomeishoHakkoRelate.setShinsakaiIken(介護認定審査会意見と名称.toRString());
        } else if (介護認定審査会意見と略称.toRString().length() <= LENGTH_150) {
            jukyuShikakuShomeishoHakkoRelate.setShinsakaiIken(介護認定審査会意見と略称.toRString());
        } else {
            jukyuShikakuShomeishoHakkoRelate.setShinsakaiIken(介護認定審査会意見と略称.substring(0, LENGTH_150));
        }
    }

    private JukyuShikakuShomeishoHakkoRelateEntity edit備考(
            JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRelate,
            JukyuShikakuShomeishoHakkoRelateEntity ninTeiShinSeiChuDataEntity,
            IJukyuShikakuShomeishoHakkoRelateMapper jukyuShikakuShomeishoHakkoMapper) {
        
        JukyuShikakuShomeishoHakkoRelateEntity ninTeiChouSaJouEntity = jukyuShikakuShomeishoHakkoMapper
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
                    .append(new FlexibleDate(jukyuShikakuShomeishoHakkoRelate.getNinteiYukoKikanShuryoYMD()).wareki()
                            .toDateString())
                    .append(MATAHA)
                    .append(YokaigoJotaiKubun09.toValue(jukyuShikakuShomeishoHakkoRelate.getYokaigoJotaiKubunCode())
                            .getName())
                    .append(MIGIKAKO);
        }
        if (JuKyuShinSeiZiYu.指定サービス種類変更申請.getCode()
                .equals(jukyuShinseiJiyu)) {
            return  null;
        }
        if (new FlexibleDate(jukyuShikakuShomeishoHakkoRelate.getNinteiYukoKikanKaishiYMD())
                .isBefore(new FlexibleDate(get制度改正施行管理_新予防給付_適用開始日()))) {
            workBiko.append(get受給資格証明書_備考項目文言());
        }
        if (workBiko.length() <= LENGTH_240) {
            jukyuShikakuShomeishoHakkoRelate.setBiko(workBiko.toRString());
        } else {
            jukyuShikakuShomeishoHakkoRelate.setBiko(workBiko.toRString().substring(0, LENGTH_240));
        }
        return jukyuShikakuShomeishoHakkoRelate;
    }

    private RString get制度改正施行管理_新予防給付_適用開始日() {
        return BusinessConfig.get(ConfigKeysJukyuShikakuShomeishoHakko.制度改正施行管理_新予防給付_適用開始日
                , SubGyomuCode.DBU介護統計報告);
    }

    private RString get受給資格証明書_備考項目文言() {
        return BusinessConfig.get(ConfigKeysJukyuShikakuShomeishoHakko.受給資格証明書_備考項目文言
                , SubGyomuCode.DBD介護受給);
    }
}
