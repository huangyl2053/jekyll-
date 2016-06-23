/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.jukyushikakushomeishohakko;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbz.business.core.jukyushikakushomeishohakko.JukyuShikakuShomeishoModel;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.JuKyuShinSeiZiYu;
import jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysJukyuShikakuShomeishoHakko;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.jukyushikakushomeishohakko.JukyuShikakuShomeishoHakkoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.JukyuShikakuShomeishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.jukyushikakushomeishohakko.IJukyuShikakuShomeishoHakkoRelateMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 受給資格証明書を管理するクラスです。
 *
 * @reamsid_L DBA-1090-020 wangkun
 */
public class JukyuShikakuShomeishoHakkoFinder {

    private static final RString SPACE = new RString("　");
    private static final RString SAKAKO = new RString("（");
    private static final RString MIGIKAKO = new RString("）");
    private static final RString MATAHA = new RString("までは");
    private static final RString 所得 = new RString("所得");
    private static final RString 単身収入 = new RString("単身収入");
    private static final RString 世帯収入 = new RString("世帯収入");
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
        JukyuShikakuShomeishoHakkoRelateEntity 負担割合情報Entity = jukyuShikakuShomeishoHakko
                .getFuDanuRiAiKuBen(受給資格証明書発行情報の検索キー);
        if (負担割合情報Entity != null) {
            edit負担割合(jukyuShikakuShomeishoHakkoRe, 負担割合情報Entity);
        }
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
        RStringBuilder 介護認定審査会意見と名称 = new RStringBuilder(jukyuShikakuShomeishoHakkoRe.getShinsakaiIken() == null
                ? RString.EMPTY : jukyuShikakuShomeishoHakkoRe.getShinsakaiIken());
        介護認定審査会意見と名称.append(SPACE);
        介護認定審査会意見と名称.append(サービス種類名称リスト.get(FIRST_INDEX));
        for (int i = 1; i < サービス種類名称リスト.size(); i++) {
            if (サービス種類名称リスト.get(i) != null && !サービス種類名称リスト.get(i).trim().isEmpty()) {
                介護認定審査会意見と名称.append(読点);
                介護認定審査会意見と名称.append(サービス種類名称リスト.get(i));
            }
        }
        RStringBuilder 介護認定審査会意見と略称 = new RStringBuilder(jukyuShikakuShomeishoHakkoRe.getShinsakaiIken() == null
                ? RString.EMPTY : jukyuShikakuShomeishoHakkoRe.getShinsakaiIken());
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
                            .get名称())
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

    private JukyuShikakuShomeishoHakkoRelateEntity edit負担割合(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRe,
            JukyuShikakuShomeishoHakkoRelateEntity 負担割合情報Entity) {
        if (!RString.isNullOrEmpty(負担割合情報Entity.getFutanWariaiKubun())) {
            jukyuShikakuShomeishoHakkoRe.setFutanWariaiKubun(負担割合情報Entity.getFutanWariaiKubun());
            if (FutanwariaiKubun._２割.getコード().equals(負担割合情報Entity.getFutanWariaiKubun())) {
                jukyuShikakuShomeishoHakkoRe.setFutanWariai(RString.EMPTY);
            } else if (FutanwariaiKubun._１割.getコード().equals(負担割合情報Entity.getFutanWariaiKubun())) {
                条件＿本人合計所得金額(jukyuShikakuShomeishoHakkoRe, 負担割合情報Entity);
            }
        }
        return jukyuShikakuShomeishoHakkoRe;
    }

    private void 条件＿本人合計所得金額(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRe,
            JukyuShikakuShomeishoHakkoRelateEntity 負担割合情報Entity) {
        Decimal honninGoukeiShotokuGakutem = 負担割合情報Entity.getHonninGoukeiShotokuGaku() == null
                ? Decimal.ZERO : 負担割合情報Entity.getHonninGoukeiShotokuGaku();
        if (new Decimal("1600000").compareTo(honninGoukeiShotokuGakutem) >= 0) {
            jukyuShikakuShomeishoHakkoRe.setFutanWariai(所得);
        } else {
            条件＿世帯１号被保険者数(jukyuShikakuShomeishoHakkoRe, 負担割合情報Entity);
        }
    }

    private void 条件＿世帯１号被保険者数(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRe,
            JukyuShikakuShomeishoHakkoRelateEntity 負担割合情報Entity) {
        if (負担割合情報Entity.getSetaiIchigouHihokenshaSu() == 1) {
            条件＿年金収入合計とその他の合計所得金額合計_1(jukyuShikakuShomeishoHakkoRe, 負担割合情報Entity);
        } else if (負担割合情報Entity.getSetaiIchigouHihokenshaSu() >= 2) {
            条件＿年金収入合計とその他の合計所得金額合計_2(jukyuShikakuShomeishoHakkoRe, 負担割合情報Entity);
        }
    }

    private void 条件＿年金収入合計とその他の合計所得金額合計_1(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRe,
            JukyuShikakuShomeishoHakkoRelateEntity 負担割合情報Entity) {
        Decimal sonotanoGoukeitemp = 負担割合情報Entity.getSonotanoGoukeiShotokuKingakuGoukei() == null
                ? Decimal.ZERO : 負担割合情報Entity.getSonotanoGoukeiShotokuKingakuGoukei();
        Decimal nenkinShunyuGoutemp = 負担割合情報Entity.getNenkinShunyuGoukei() == null ? Decimal.ZERO : 負担割合情報Entity.getNenkinShunyuGoukei();
        Decimal total = sonotanoGoukeitemp.add(nenkinShunyuGoutemp);
        if (new Decimal("2800000").compareTo(total) >= 0) {
            jukyuShikakuShomeishoHakkoRe.setFutanWariai(単身収入);
        } else {
            jukyuShikakuShomeishoHakkoRe.setFutanWariai(RString.EMPTY);
        }
    }

    private void 条件＿年金収入合計とその他の合計所得金額合計_2(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakkoRe,
            JukyuShikakuShomeishoHakkoRelateEntity 負担割合情報Entity) {
        Decimal sonotanoGoukeitemp = 負担割合情報Entity.getSonotanoGoukeiShotokuKingakuGoukei() == null
                ? Decimal.ZERO : 負担割合情報Entity.getSonotanoGoukeiShotokuKingakuGoukei();
        Decimal nenkinShunyuGoutemp = 負担割合情報Entity.getNenkinShunyuGoukei() == null ? Decimal.ZERO : 負担割合情報Entity.getNenkinShunyuGoukei();
        Decimal total = sonotanoGoukeitemp.add(nenkinShunyuGoutemp);
        if (new Decimal("3460000").compareTo(total) >= 0) {
            jukyuShikakuShomeishoHakkoRe.setFutanWariai(世帯収入);
        } else {
            jukyuShikakuShomeishoHakkoRe.setFutanWariai(RString.EMPTY);
        }
    }

    private RString get制度改正施行管理_新予防給付_適用開始日() {
        return DbBusinessConfig.get(ConfigKeysJukyuShikakuShomeishoHakko.制度改正施行管理_新予防給付_適用開始日, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
    }

    private RString get受給資格証明書_備考項目文言() {
        Map<Integer, RString> 通知文List = ReportUtil.get通知文(SubGyomuCode.DBA介護資格, new ReportId("DBA100004_JukyuShikakuShomeisho"),
                KamokuCode.EMPTY, 1);
        RStringBuilder sb = new RStringBuilder();
        Iterator<Map.Entry<Integer, RString>> keySet = 通知文List.entrySet().iterator();
        while (keySet.hasNext()) {
            sb.append(keySet.next().getValue());
        }
        return sb.toRString();
    }
}
