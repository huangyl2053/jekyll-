/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyoutsuu.HihokenshaAndDaichouAndAtenaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyoutsuu.HihokenshaAndHenkanBangoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho.GappeiCityJyoho;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.gappeijoho.GappeiJyohoSpecificParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 国保連情報取込処理共通のビジネスです。<br>
 * 被保険者関連処理
 *
 * @reamsid_L DBC-0980-560 zhangrui
 */
public class KokuhorenKyoutsuuHihokansyaKanrenManager {

    private final MapperProvider mapperProvider;
    private final IKokuhorenKyoutsuuMapper mapper;
    private final GappeiCityJohoBFinder finder;

    private static final RString MSG_被保険者番号変換基準日の取得 = new RString("被保険者番号変換基準日の取得");
    private static final RString MSG_エラー区分10 = new RString("10");
    private static final RString MSG_エラー区分20 = new RString("20");
    private static final RString MSG_エラー区分30 = new RString("30");

    /**
     * 国保連情報取込共通処理（被保険者関連処理）のコンストラクタ。
     *
     */
    public KokuhorenKyoutsuuHihokansyaKanrenManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.finder = GappeiCityJohoBFinder.createInstance();
        this.mapper = mapperProvider.create(IKokuhorenKyoutsuuMapper.class);
    }

    /**
     * 国保連情報取込共通処理（被保険者関連処理）のコンストラクタ。
     *
     * @return KokuhorenKyoutsuuHihokansyaKanrenManager
     */
    public static KokuhorenKyoutsuuHihokansyaKanrenManager createInstance() {
        return InstanceProvider.create(KokuhorenKyoutsuuHihokansyaKanrenManager.class);
    }

    /**
     * 被保険者関連処理
     *
     */
    public void do被保険者関連処理() {
        FlexibleDate 変換基準日 = finder.getHihokenshaBangoHenkanKijunbi(GyomuBunrui.介護事務);
        if (null == 変換基準日) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage()
                    .replace(MSG_被保険者番号変換基準日の取得.toString()));
        } else if (変換基準日.equals(FlexibleDate.EMPTY)) {
            do変換被保険者番号の更新();
        } else {
            do旧市町村コードの取得(変換基準日);
        }

        List<HihokenshaAndDaichouAndAtenaEntity> list = mapper.select被保険者And宛名情報();
        for (HihokenshaAndDaichouAndAtenaEntity entity : list) {
            if (null != entity.getDaicho() && null != entity.getAtena()
                    && null != entity.getDaicho().getHihokenshaNo() && null != entity.getAtena().getShikibetsuCode()) {
                do被保険者宛名情報を被保険者一時TBLに登録(entity);
            } else if (null == entity.getDaicho() || null == entity.getDaicho().getHihokenshaNo()) {
                do被保険者情報が取得できなかったデータをエラー登録する(entity.getHihokensha());
            } else if (null == entity.getAtena() || null == entity.getAtena().getShikibetsuCode()) {
                do宛名情報が取得できなかったデータをエラー登録する(entity.getHihokensha());
            }
        }
    }

    private void do旧市町村コードの取得(FlexibleDate 変換基準日) {
        List<DbWT0001HihokenshaTempEntity> list = mapper.select被保険者番号変換対象(変換基準日);
        Set<ShoKisaiHokenshaNo> hokenshaNoSet = new HashSet<>();
        for (DbWT0001HihokenshaTempEntity entity : list) {
            hokenshaNoSet.add(entity.get証記載保険者番号());
        }
        if (!hokenshaNoSet.isEmpty()) {
            for (ShoKisaiHokenshaNo shoHokenshaNo : hokenshaNoSet) {
                HokenshaNo hokenshaNo = new HokenshaNo(getColumnValue(shoHokenshaNo));
                GappeiJyohoSpecificParameter parameter
                        = GappeiJyohoSpecificParameter.createParamForKouikigappeijohokennsaku(LasdecCode.EMPTY, hokenshaNo);
                SearchResult<GappeiCityJyoho> gcJohoResult
                        = finder.getGappeijohokensaku(RString.EMPTY, parameter, GyomuBunrui.介護事務);
                if (null == gcJohoResult || null == gcJohoResult.records() || gcJohoResult.records().isEmpty()) {
                    do新被保険者番号の登録(変換基準日);
                    continue;
                }
                LasdecCode 旧市町村コード = gcJohoResult.records().get(0).get旧市町村コード();
                if (!LasdecCode.EMPTY.equals(旧市町村コード) && null != 旧市町村コード) {
                    mapper.update被保険者一時TBLWith旧市町村コード(hokenshaNo, 旧市町村コード);
                }
                do新被保険者番号の登録(変換基準日);
            }
        } else {
            do変換被保険者番号の更新();
        }
    }

    private void do新被保険者番号の登録(FlexibleDate 変換基準日) {
        List<HihokenshaAndHenkanBangoEntity> list = mapper.select新被保険者番号();
        for (HihokenshaAndHenkanBangoEntity entity : list) {
            if (null == entity.getShichosonCode2() || RString.isNullOrEmpty(entity.getShichosonCode2().value())) {
                doエラー登録(entity);
                return;
            }
            mapper.update被保険者一時TBLWith新被保険者番号(entity.get連番(), entity.getShinNo());
        }
        mapper.update被保険者一時TBLWith現被保険者番号(変換基準日);
    }

    private void do変換被保険者番号の更新() {
        mapper.update被保険者番号WithEmpty変換被保険者番号();
    }

    private void do被保険者宛名情報を被保険者一時TBLに登録(HihokenshaAndDaichouAndAtenaEntity entity) {
        IShikibetsuTaisho 識別対象 = ShikibetsuTaishoFactory.createKojin(entity.getAtena());
        DbT1001HihokenshaDaichoEntity daicho = entity.getDaicho();
        DbWT0001HihokenshaTempEntity saveEntity = entity.getHihokensha();
        saveEntity.set管内管外区分(識別対象.get住所().get管内管外().toRString());
        saveEntity.set郵便番号(識別対象.get住所().get郵便番号().getYubinNo());
        saveEntity.set町域コード(getColumnValue(識別対象.get住所().get町域コード()));
        saveEntity.set行政区コード(getColumnValue(識別対象.get行政区画().getGyoseiku().getコード()));
        saveEntity.set行政区名(識別対象.get行政区画().getGyoseiku().get名称());
        saveEntity.set住所(識別対象.get住所().get住所());
        saveEntity.set番地(getColumnValue(識別対象.get住所().get番地().getBanchi()));
        saveEntity.set方書(getColumnValue(識別対象.get住所().get方書()));
        saveEntity.set宛名カナ名称(getColumnValue(識別対象.get名称().getKana()));
        saveEntity.set宛名名称(getColumnValue(識別対象.get名称().getName()));
        saveEntity.set氏名50音カナ(RStringUtil.convertTo清音化(getColumnValue(識別対象.get名称().getKana())));
        saveEntity.set識別コード(getColumnValue(識別対象.get識別コード()));
        saveEntity.set市町村コード(daicho.getShichosonCode());
        saveEntity.set資格取得日(daicho.getShikakuShutokuYMD());
        saveEntity.set資格取得事由コード(daicho.getShikakuShutokuJiyuCode());
        saveEntity.set資格喪失日(daicho.getShikakuSoshitsuYMD());
        saveEntity.set資格喪失事由コード(daicho.getShikakuSoshitsuJiyuCode());
        mapper.update被保険者一時TBLWith被保険者宛名情報(saveEntity);
    }

    private void doエラー登録(HihokenshaAndHenkanBangoEntity entity) {
        DbWT0002KokuhorenTorikomiErrorTempEntity kekka = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        kekka.setエラー区分(MSG_エラー区分10);
        kekka.set証記載保険者番号(entity.get証記載保険者番号());
        kekka.set被保険者番号(entity.get登録被保険者番号());
        kekka.setキー1(RString.EMPTY);
        kekka.setキー2(RString.EMPTY);
        kekka.setキー3(RString.EMPTY);
        kekka.setキー4(RString.EMPTY);
        kekka.setキー5(RString.EMPTY);
        kekka.set被保険者カナ氏名(entity.get被保険者カナ氏名());
        kekka.set被保険者氏名(entity.get被保険者氏名());
        kekka.set備考(RString.EMPTY);
        do一意排他登録処理結果(kekka);
    }

    private void do被保険者情報が取得できなかったデータをエラー登録する(DbWT0001HihokenshaTempEntity hihokensha) {
        DbWT0002KokuhorenTorikomiErrorTempEntity kekka = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        kekka.setエラー区分(MSG_エラー区分20);
        kekka.set証記載保険者番号(hihokensha.get証記載保険者番号());
        kekka.set被保険者番号(hihokensha.get登録被保険者番号());
        kekka.setキー1(RString.EMPTY);
        kekka.setキー2(RString.EMPTY);
        kekka.setキー3(RString.EMPTY);
        kekka.setキー4(RString.EMPTY);
        kekka.setキー5(RString.EMPTY);
        kekka.set被保険者カナ氏名(hihokensha.get被保険者カナ氏名());
        kekka.set被保険者氏名(hihokensha.get被保険者氏名());
        kekka.set備考(RString.EMPTY);
        do一意排他登録処理結果(kekka);
    }

    private void do宛名情報が取得できなかったデータをエラー登録する(DbWT0001HihokenshaTempEntity hihokensha) {
        DbWT0002KokuhorenTorikomiErrorTempEntity kekka = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        kekka.setエラー区分(MSG_エラー区分30);
        kekka.set証記載保険者番号(hihokensha.get証記載保険者番号());
        kekka.set被保険者番号(hihokensha.get登録被保険者番号());
        kekka.setキー1(RString.EMPTY);
        kekka.setキー2(RString.EMPTY);
        kekka.setキー3(RString.EMPTY);
        kekka.setキー4(RString.EMPTY);
        kekka.setキー5(RString.EMPTY);
        kekka.set被保険者カナ氏名(hihokensha.get被保険者カナ氏名());
        kekka.set被保険者氏名(hihokensha.get被保険者氏名());
        kekka.set備考(RString.EMPTY);
        do一意排他登録処理結果(kekka);
    }

    private boolean do一意排他登録処理結果(DbWT0002KokuhorenTorikomiErrorTempEntity kekka) {
        if (mapper.count処理結果ByPK(kekka) == 0) {
            mapper.insert処理結果リスト一時TBL(kekka);
        } else {
            return false;
        }
        return true;
    }

    private RString getColumnValue(IDbColumnMappable column) {
        if (null == column) {
            return RString.EMPTY;
        }
        return column.getColumnValue();
    }

}
