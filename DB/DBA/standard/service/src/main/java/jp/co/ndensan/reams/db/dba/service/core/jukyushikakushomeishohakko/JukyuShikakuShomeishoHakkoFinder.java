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
import jp.co.ndensan.reams.db.dba.entity.relate.JukyuShikakuShomeishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.jukyushikakushomeishohakko.IJukyuShikakuShomeishoHakkoRelateMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;   
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 *
 */
public class JukyuShikakuShomeishoHakkoFinder {

    private final MapperProvider mapperProvider;
    private final RString space = new RString("　");
    private final RString sakako = new RString("（");
    private final RString migikako = new RString("）");
    private final RString mataha = new RString("までは");
    private final int int_150 = 150;
    private final int int_240 = 240;

    public JukyuShikakuShomeishoHakkoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JukyuShikakuShomeishoHakkoFinder}のインスタンスを返します。
     *
     * @return JukyuShikakuShomeishoHakkoFinder
     */
    public static JukyuShikakuShomeishoHakkoFinder createInstance() {
        return InstanceProvider.create(JukyuShikakuShomeishoHakkoFinder.class);
    }

    /**
     * 被保険者番号をキーに受給者台帳テーブル、 要介護認定結果情報テーブルと宛名識別対象PSMからデータを取得する。
     *
     * @param parameter
     * @return JukyuShikakuShomeisho JukyuShikakuShomeishoHakkoParameter
     */
    public JukyuShikakuShomeishoModel getJukyuShikakuShomeishoHakko(JukyuShikakuShomeishoHakkoParameter parameter) {

        // 受給資格証明書発行情報を取得
        IJukyuShikakuShomeishoHakkoRelateMapper jukyuShikakuShomeishoHakkoMapper = mapperProvider.
                create(IJukyuShikakuShomeishoHakkoRelateMapper.class);
        JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRelate = jukyuShikakuShomeishoHakkoMapper.
                getJukyuShikakuShomeishoHakko(parameter);
        
        // TODO 備考←未設定（NULL）確認を待ち
        if (jukyuShikakuShomeishoHakkoRelate == null) {
            return new JukyuShikakuShomeishoModel(null);
        }
        // サービス種類コードListを取得する
        JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoCode = jukyuShikakuShomeishoHakkoMapper.
                getServiceCodeList(parameter);
        // サービス種類名称とサービス種類略称Listを取得する
        get種類名称と種類略称(jukyuShikakuShomeishoHakkoRelate, jukyuShikakuShomeishoHakkoCode, jukyuShikakuShomeishoHakkoMapper);
        JukyuShikakuShomeishoHakkoRelateEntity ninTeiShinSeiChuDataEntity = jukyuShikakuShomeishoHakkoMapper.getNinTeiShinSeiChuData(parameter);
        // 認定申請中データが取得できなかった場合
        if (ninTeiShinSeiChuDataEntity == null) {
            if (new FlexibleDate(get制度改正施行管理_新予防給付_適用開始日())
                 .isBefore(new FlexibleDate(jukyuShikakuShomeishoHakkoRelate.getNinteiYukoKikanKaishiYMD()))) {
                jukyuShikakuShomeishoHakkoRelate.setBiko(get受給資格証明書_備考項目文言());
            } else {
                // TODO 備考←未設定（NULL）確認を待ち
                jukyuShikakuShomeishoHakkoRelate.setBiko(RString.EMPTY);
            }
        } else {
            set備考(jukyuShikakuShomeishoHakkoRelate, ninTeiShinSeiChuDataEntity, jukyuShikakuShomeishoHakkoMapper);
        }
        return new JukyuShikakuShomeishoModel(jukyuShikakuShomeishoHakkoRelate);
    }

    private void get種類名称と種類略称(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRelate,
            JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoCode,
            IJukyuShikakuShomeishoHakkoRelateMapper jukyuShikakuShomeishoHakkoMapper) {
        List<RString> サービス種類コードList = サービス種類コードEideList(jukyuShikakuShomeishoHakkoCode);
        List<RString> サービス種類名称リスト = new ArrayList<>();
        List<RString> サービス種類略称リスト = new ArrayList<>();
        for (RString code : サービス種類コードList) {
            JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoTemp = jukyuShikakuShomeishoHakkoMapper
                    .getServiceMeiList(JukyuShikakuShomeishoHakkoParameter.createSearchParameter_サービス種類コード(code.trimEnd()));
            if (jukyuShikakuShomeishoHakkoTemp != null) {
                サービス種類名称リスト.add(jukyuShikakuShomeishoHakkoTemp.getServiceShuruiMeisho());
                サービス種類略称リスト.add(jukyuShikakuShomeishoHakkoTemp.getServiceShuruiRyakusho());
            } else {
                サービス種類名称リスト.add(RString.EMPTY);
                サービス種類略称リスト.add(RString.EMPTY);
            }
        }
        set介護認定審査会意見(jukyuShikakuShomeishoHakkoRelate, サービス種類名称リスト, サービス種類略称リスト);
    }

    private List<RString> サービス種類コードEideList(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRelate) {
        List<RString> サービス種類コードList = new ArrayList<>();
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui01());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui02());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui03());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui04());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui05());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui06());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui07());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui08());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui09());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui10());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui11());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui12());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui13());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui14());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui15());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui16());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui17());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui18());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui19());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui20());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui21());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui22());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui23());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui24());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui25());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui26());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui27());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui28());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui29());
        サービス種類コードList.add(jukyuShikakuShomeishoHakkoRelate.getShiteiServiceShurui30());
        return サービス種類コードList;
    }

    private void set介護認定審査会意見(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRelate,
            List<RString> サービス種類名称リスト, List<RString> サービス種類略称リスト) {
        RStringBuilder 介護認定審査会意見と名称 = new RStringBuilder(jukyuShikakuShomeishoHakkoRelate.getShinsakaiIken());
        介護認定審査会意見と名称.append(space);
        for (RString サービス種類名称 : サービス種類名称リスト) {
            介護認定審査会意見と名称.append(サービス種類名称);
        }
        RStringBuilder 介護認定審査会意見と略称 = new RStringBuilder(jukyuShikakuShomeishoHakkoRelate.getShinsakaiIken());
        介護認定審査会意見と略称.append(space);
        for (RString サービス種類略称 : サービス種類略称リスト) {
            介護認定審査会意見と略称.append(サービス種類略称);
        }
        if (介護認定審査会意見と名称.toRString().length() <= int_150) {
            jukyuShikakuShomeishoHakkoRelate.setShinsakaiIken(介護認定審査会意見と名称.toRString());
        } else if (介護認定審査会意見と略称.toRString().length() <= int_150) {
            jukyuShikakuShomeishoHakkoRelate.setShinsakaiIken(介護認定審査会意見と略称.toRString());
        } else {
            jukyuShikakuShomeishoHakkoRelate.setShinsakaiIken(介護認定審査会意見と略称.substring(0, int_150));
        }
    }

    private void set備考(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRelate, 
            JukyuShikakuShomeishoHakkoRelateEntity ninTeiShinSeiChuDataEntity, 
            IJukyuShikakuShomeishoHakkoRelateMapper jukyuShikakuShomeishoHakkoMapper) {
        JukyuShikakuShomeishoHakkoRelateEntity ninTeiChouSaJouEntity = jukyuShikakuShomeishoHakkoMapper
                .getNinTeiChouSaJou(JukyuShikakuShomeishoHakkoParameter.
                        createSearchParameter_認定申請中データ情報(ninTeiShinSeiChuDataEntity.getShinseishoKanriNo()));
        RStringBuilder workBiko = new RStringBuilder(RString.EMPTY);
        // TODO 汪坤　　QA38　DBD.Enum受給申請事由とDBD.Enum受給資格証明書申請種類文言のクラスが未提供ですので、
        // とりあえず全てJuKyuShinSeiZiYuで仮定義しています
        if (ninTeiShinSeiChuDataEntity.getJukyuShinseiJiyu().equals(JuKyuShinSeiZiYu.初回申請.getCode())
                || ninTeiShinSeiChuDataEntity.getJukyuShinseiJiyu().equals(JuKyuShinSeiZiYu.再申請_有効期限外.getCode())
                || ninTeiShinSeiChuDataEntity.getJukyuShinseiJiyu().equals(JuKyuShinSeiZiYu.要介護度変更申請.getCode())
                || ninTeiShinSeiChuDataEntity.getJukyuShinseiJiyu().equals(JuKyuShinSeiZiYu.申請_法施行前.getCode())) {

            if (ninTeiShinSeiChuDataEntity.getJukyuShinseiJiyu().equals(JuKyuShinSeiZiYu.要介護度変更申請.getCode()) 
                 && !ninTeiShinSeiChuDataEntity.getYoshienshaNinteiShinseiFlag()) {
                workBiko = workBiko.append(JuKyuShinSeiZiYu.区分変更申請中で_認定調査.getCode());
            } else {
                workBiko = workBiko.append(JuKyuShinSeiZiYu.要介護認定申請中で_認定審査.getCode());
            }
            if (ninTeiChouSaJouEntity == null) {
                workBiko = workBiko.append(JuKyuShinSeiZiYu.未.getCode());
            } else {
                if (ninTeiChouSaJouEntity.getNinteichosaJisshiYMD() != null) {
                    workBiko = workBiko.append(JuKyuShinSeiZiYu.済.getCode());
                } else {
                    workBiko = workBiko.append(JuKyuShinSeiZiYu.未.getCode());
                }
            }
        }
        if (ninTeiShinSeiChuDataEntity.getJukyuShinseiJiyu().equals(JuKyuShinSeiZiYu.再申請_有効期限内.getCode())) {
            workBiko = workBiko.append(JuKyuShinSeiZiYu.更新認定申請中で_認定結果未.getCode());
            workBiko = workBiko.append(sakako)
                    .append(new FlexibleDate(jukyuShikakuShomeishoHakkoRelate.getNinteiYukoKikanShuryoYMD()).wareki().toDateString())
                    .append(mataha)
                    .append(YokaigoJotaiKubun09.toValue(jukyuShikakuShomeishoHakkoRelate.getYokaigoJotaiKubunCode()).getName())
                    .append(migikako);
        }
        if (ninTeiShinSeiChuDataEntity.getJukyuShinseiJiyu().equals(JuKyuShinSeiZiYu.指定サービス種類変更申請.getCode())) {
            // TODO 受給資格証明書発行情報EntityにNULLを設定して、処理終了。   　確認を待ち
            jukyuShikakuShomeishoHakkoRelate = new JukyuShikakuShomeishoHakkoRelateEntity();
        }
        System.out.println(get制度改正施行管理_新予防給付_適用開始日());
        System.out.println(jukyuShikakuShomeishoHakkoRelate.getNinteiYukoKikanKaishiYMD());
        if (new FlexibleDate(get制度改正施行管理_新予防給付_適用開始日()).isBefore(new FlexibleDate(jukyuShikakuShomeishoHakkoRelate.getNinteiYukoKikanKaishiYMD()))) {
           System.out.println(get制度改正施行管理_新予防給付_適用開始日());
           System.out.println(jukyuShikakuShomeishoHakkoRelate.getNinteiYukoKikanKaishiYMD());
            workBiko.append(get受給資格証明書_備考項目文言());
        }
        if (workBiko.length() <= int_240) {
            jukyuShikakuShomeishoHakkoRelate.setBiko(workBiko.toRString());
        } else {
            jukyuShikakuShomeishoHakkoRelate.setBiko(workBiko.toRString().substring(0, int_240));
        }
    }

    private RString get制度改正施行管理_新予防給付_適用開始日() {
        return BusinessConfig.get(ConfigKeysJukyuShikakuShomeishoHakko.制度改正施行管理_新予防給付_適用開始日, SubGyomuCode.DBU介護統計報告);
    }

    private RString get受給資格証明書_備考項目文言() {
        return BusinessConfig.get(ConfigKeysJukyuShikakuShomeishoHakko.受給資格証明書_備考項目文言, SubGyomuCode.DBD介護受給);
    }
}
