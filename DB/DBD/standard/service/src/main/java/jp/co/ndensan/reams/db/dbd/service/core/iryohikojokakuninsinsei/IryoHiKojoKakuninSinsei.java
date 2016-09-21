/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.iryohikojokakuninsinsei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.IryohiKojoEntityResult;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.OmutsusiyoSyomeishoEntity;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.iryohikojokakuninsinsei.AtesakiParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.iryohikojokakuninsinsei.ShikibetsuTaishoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.iryohikojokakuninsinsei.IryohiKojoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.iryohikojokakuninsinsei.SogoJigyouTaisyouSyaJyohoJoho;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.iryohikojokakuninsinsei.IIryoHiKojoKakuninSinseiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.JushoHenshuChoikiHenshuHoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.jusho.JushoEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoKannaiEditPattern;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoPrefix;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計医療費控除確認申請
 *
 * @reamsid_L DBD-5770-030 x_zhaowen
 */
public class IryoHiKojoKakuninSinsei {

    private static final RString 表示する = new RString("1");
    private static final RString 性別男 = new RString("1");
    private static final RString 選択する = new RString("○");
    private static final int サーティ = 30;
    private final MapperProvider mapperProvider;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;

    /**
     * コンストラクタです。
     */
    public IryoHiKojoKakuninSinsei() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * Intanceを作成します。
     *
     * @return IryoHiKojoKakuninSinsei
     */
    public static IryoHiKojoKakuninSinsei createIntance() {
        return InstanceProvider.create(IryoHiKojoKakuninSinsei.class);
    }

    /**
     * 受給者判定
     *
     * @param 被保険者番号 RString
     * @return boolean
     */
    public boolean checkuJukyusha(RString 被保険者番号) {
        IIryoHiKojoKakuninSinseiMapper mapper = mapperProvider.create(IIryoHiKojoKakuninSinseiMapper.class);
        Integer レコード数 = mapper.受給者台帳抽出(被保険者番号);
        return レコード数 > 0;
    }

    /**
     * 受給者台帳取得
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年 対象年
     * @return 受給者台帳情報
     */
    public SogoJigyouTaisyouSyaJyohoJoho getJukyusha(RString 被保険者番号, RString 対象年) {
        IIryoHiKojoKakuninSinseiMapper mapper = mapperProvider.create(IIryoHiKojoKakuninSinseiMapper.class);
        SogoJigyouTaisyouSyaJyohoJoho 受給者台帳情報 = mapper.select受給者台帳情報(被保険者番号, 対象年);
        if (受給者台帳情報 == null) {
            受給者台帳情報 = new SogoJigyouTaisyouSyaJyohoJoho();
        }
        return 受給者台帳情報;
    }

    /**
     * 医療費控除取得
     */
    public void getIryohikojyo() {

    }

    /**
     * 単票用医療費控除取得
     *
     * @param 被保険者番号 被保険者番号
     * @param データ区分 データ区分
     * @return 医療費控除情報
     */
    public List<IryohiKojoEntityResult> getIryohikojyo_Chohyo(RString 被保険者番号, RString データ区分) {
        IIryoHiKojoKakuninSinseiMapper mapper = mapperProvider.create(IIryoHiKojoKakuninSinseiMapper.class);
        List<IryohiKojoEntityResult> 単票用医療費控除 = new ArrayList<>();
        List<IryohiKojoEntity> result = mapper.select単票用医療費控除(被保険者番号, データ区分);
        if (result != null) {
            for (IryohiKojoEntity entity : result) {
                IryohiKojoEntityResult 医療費控除 = new IryohiKojoEntityResult();
                医療費控除.setデータ区分(entity.getデータ区分());
                医療費控除.set主治医意見書受領年月日(entity.get主治医意見書受領年月日());
                医療費控除.set尿失禁の有無(entity.is尿失禁の有無());
                医療費控除.set控除対象年(entity.get控除対象年());
                医療費控除.set日常生活自立度(entity.get日常生活自立度());
                医療費控除.set申請年月日(entity.get申請年月日());
                医療費控除.set発行年月日(entity.get発行年月日());
                医療費控除.set登録年月日(entity.get登録年月日());
                医療費控除.set被保険者番号(entity.get被保険者番号());
                医療費控除.set認定有効期間終了年月日(entity.get認定有効期間終了年月日());
                医療費控除.set認定有効期間開始年月日(entity.get認定有効期間開始年月日());
                単票用医療費控除.add(医療費控除);
            }
        }
        return 単票用医療費控除;
    }

    /**
     * おむつ使用証明書
     *
     * @param 識別コード ShikibetsuCode
     * @param 帳票分類ID RString
     * @return おむつ使用証明書Entity OmutsusiyoSyomeishoEntity
     */
    public OmutsusiyoSyomeishoEntity editomutsusiyoSyomeisho(ShikibetsuCode 識別コード, RString 帳票分類ID) {
        OmutsusiyoSyomeishoEntity おむつ使用証明書Entity = new OmutsusiyoSyomeishoEntity();
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBD介護受給, new ReportId(帳票分類ID));
        RString 管内住所編集_都道府県名付与有無 = DbBusinessConfig.getConfigInfo(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無,
                SubGyomuCode.DBU介護統計報告).getConfigValue();
        RString 管内住所編集_郡名付与有無 = DbBusinessConfig.getConfigInfo(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無,
                SubGyomuCode.DBU介護統計報告).getConfigValue();
        RString 管内住所編集_市町村名付与有無 = DbBusinessConfig.getConfigInfo(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無,
                SubGyomuCode.DBU介護統計報告).getConfigValue();
        RString 管内住所編集_編集方法 = DbBusinessConfig.getConfigInfo(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法,
                SubGyomuCode.DBU介護統計報告).getConfigValue();
        RString 住所編集_方書表示有無 = DbBusinessConfig.getConfigInfo(
                ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無,
                SubGyomuCode.DBU介護統計報告).getConfigValue();
        if (帳票制御共通 != null) {
            if (帳票制御共通.getJushoHenshuTodoufukenMeiHyojiUmu()) {
                管内住所編集_都道府県名付与有無 = 表示する;
            }
            if (帳票制御共通.getJushoHenshuGunMeiHyojiUmu()) {
                管内住所編集_郡名付与有無 = 表示する;
            }
            if (帳票制御共通.getJushoHenshuShichosonMeiHyojiUmu()) {
                管内住所編集_市町村名付与有無 = 表示する;
            }
            管内住所編集_編集方法 = 帳票制御共通.getJushoHenshuChoikiHenshuHoho();
            if (帳票制御共通.getJushoHenshuKatagakiHyojiUmu()) {
                住所編集_方書表示有無 = 表示する;
            }
        }

        IKojin 宛名情報 = getAtena_Iryohikojyo(識別コード);
        if (宛名情報 == null || JushoHenshuChoikiHenshuHoho.表示なし_住所は印字しない.getコード().equals(管内住所編集_編集方法)) {
            return null;
        }
        JushoEditorBuilder jushoEditorBuilder = new JushoEditorBuilder(宛名情報.get住所());
        if (表示する.equals(管内住所編集_都道府県名付与有無)) {
            jushoEditorBuilder.set管内住所接頭辞(JushoPrefix.県_郡_市町村名付加, 地方公共団体);
        } else if (表示する.equals(管内住所編集_郡名付与有無)) {
            jushoEditorBuilder.set管内住所接頭辞(JushoPrefix.郡_市町村名付加, 地方公共団体);
        } else if (表示する.equals(管内住所編集_市町村名付与有無)) {
            jushoEditorBuilder.set管内住所接頭辞(JushoPrefix.市町村名付加, 地方公共団体);
        } else {
            jushoEditorBuilder.set管内住所接頭辞(JushoPrefix.付加しない, 地方公共団体);
        }

        if (JushoHenshuChoikiHenshuHoho.行政区足す番地.getコード().equals(管内住所編集_編集方法)) {
            if (表示する.equals(住所編集_方書表示有無)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.行政区番地space方書);
            } else {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.行政区番地);
            }
        } else if (JushoHenshuChoikiHenshuHoho.住所足す番地_行政区.getコード().equals(管内住所編集_編集方法)) {
            if (表示する.equals(住所編集_方書表示有無)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地カッコ行政区space方書);
            } else {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地カッコ行政区);
            }
        } else {
            if (表示する.equals(住所編集_方書表示有無)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.行政区番地space方書);
            } else {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.行政区番地);
            }
        }
        jushoEditorBuilder.set行政区(宛名情報.get行政区画().getGyoseiku());
        RString 編集後住所 = jushoEditorBuilder.build().editJusho().get編集後住所All();

        おむつ使用証明書Entity.set住所(編集後住所);
        if (編集後住所.length() <= サーティ) {
            おむつ使用証明書Entity.set住所１(RString.EMPTY);
            おむつ使用証明書Entity.set住所２(RString.EMPTY);
        } else {
            おむつ使用証明書Entity.set住所１(編集後住所.substring(0, サーティ));
            おむつ使用証明書Entity.set住所２(編集後住所.substring(サーティ));

        }
        RString 氏名 = 宛名情報.get外国人氏名().getName().value();
        おむつ使用証明書Entity.set氏名(氏名);
        if (氏名.length() <= サーティ) {
            おむつ使用証明書Entity.set氏名１(RString.EMPTY);
            おむつ使用証明書Entity.set氏名２(RString.EMPTY);
        } else {
            おむつ使用証明書Entity.set氏名１(氏名.substring(0, サーティ));
            おむつ使用証明書Entity.set氏名２(氏名.substring(サーティ));
        }
        おむつ使用証明書Entity.set生年月日(宛名情報.get生年月日().toFlexibleDate().seireki()
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        if (宛名情報.get性別().getCode().equals(性別男)) {
            おむつ使用証明書Entity.set性別男(選択する);
            おむつ使用証明書Entity.set性別女(RString.EMPTY);
        } else {
            おむつ使用証明書Entity.set性別男(RString.EMPTY);
            おむつ使用証明書Entity.set性別女(選択する);
        }
        return おむつ使用証明書Entity;
    }

    /**
     * 主治医意見書確認書
     */
    public void editsyujiikensho_Kakunisho() {

    }

    /**
     * 宛名取得
     *
     * @param 識別コード ShikibetsuCode
     * @return 宛名情報 IKojin
     */
    public IKojin getAtena_Iryohikojyo(ShikibetsuCode 識別コード) {
        IIryoHiKojoKakuninSinseiMapper mapper = mapperProvider.create(IIryoHiKojoKakuninSinseiMapper.class);

        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
        juminShubetsuList.add(JuminShubetsu.日本人);
        juminShubetsuList.add(JuminShubetsu.外国人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_日本人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_外国人);
        key.set住民種別(juminShubetsuList);
        List<JuminJotai> juminJotaiList = new ArrayList<>();
        juminJotaiList.add(JuminJotai.住登外);
        juminJotaiList.add(JuminJotai.消除者);
        juminJotaiList.add(JuminJotai.転出者);
        juminJotaiList.add(JuminJotai.死亡者);
        key.set住民状態(juminJotaiList);
        key.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        ShikibetsuTaishoParameter param = new ShikibetsuTaishoParameter(shikibetsuTaishoPSMSearchKey);

        UaFt200FindShikibetsuTaishoEntity 宛名情報 = mapper.select宛名情報(param);

        return 宛名情報 != null ? ShikibetsuTaishoFactory.createKojin(宛名情報) : null;
    }

    /**
     * 宛先取得
     *
     * @param 識別コード ShikibetsuCode
     * @return 宛先情報 IAtesaki
     */
    public IAtesaki getAtesaki_Iryohikojyo(ShikibetsuCode 識別コード) {
        IIryoHiKojoKakuninSinseiMapper mapper = mapperProvider.create(IIryoHiKojoKakuninSinseiMapper.class);

        AtesakiPSMSearchKeyBuilder key = new AtesakiPSMSearchKeyBuilder(
                AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        key.set識別コード(識別コード);
        AtesakiParameter param = new AtesakiParameter(key.build());

        UaFt250FindAtesakiEntity 宛先情報 = mapper.select宛先情報(param);
        return 宛先情報 != null ? AtesakiFactory.createInstance(宛先情報) : null;
    }
}
