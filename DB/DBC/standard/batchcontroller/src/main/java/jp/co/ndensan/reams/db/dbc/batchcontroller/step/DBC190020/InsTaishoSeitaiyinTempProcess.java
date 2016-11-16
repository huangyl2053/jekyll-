/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunsyunyunenji.InsTaishoSeitaiyinTempProcessMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunsyunyunenji.InsTaishoSeitaiyinTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.InsTaishoSeitaiyinTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.TaishoSetaiinEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 対象世帯員クラスTempに登録のバッチ処理フロークラスです
 *
 * @reamsid_L DBC-4630-060 jiangwenkai
 */
public class InsTaishoSeitaiyinTempProcess extends BatchProcessBase<InsTaishoSeitaiyinTempEntity> {

    private InsTaishoSeitaiyinTempProcessParameter parameter;
    private InsTaishoSeitaiyinTempProcessMybatisParameter para;

    private static final RString TABLE_NAME = new RString("TaishoSetaiin");
    private static final RString TABLE_NAME1 = new RString("TaishoSetaiin1");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_10 = new RString("10");
    private static final RString RSTRING_20 = new RString("20");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji."
            + "IKijunsyunyunenjiMapper.対象世帯員クラスTempに登録");
    private static RString tableName;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter taiShoTableWriter;

    @Override
    protected void initialize() {
        if (RSTRING_1.equals(parameter.get処理区分())) {
            tableName = TABLE_NAME;
        } else if (RSTRING_2.equals(parameter.get処理区分())) {
            tableName = TABLE_NAME1;
        }
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        List<JuminShubetsu> 住民種別List = new ArrayList();
        List<JuminJotai> 住民状態List = new ArrayList();
        住民種別List.add(JuminShubetsu.日本人);
        住民種別List.add(JuminShubetsu.外国人);
        住民種別List.add(JuminShubetsu.住登外個人_日本人);
        住民種別List.add(JuminShubetsu.住登外個人_外国人);
        住民状態List.add(JuminJotai.住登外);
        住民状態List.add(JuminJotai.消除者);
        住民状態List.add(JuminJotai.転出者);
        住民状態List.add(JuminJotai.死亡者);
        住民状態List.add(JuminJotai.住民);
        key.set住民種別(住民種別List);
        key.set住民状態(住民状態List);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        para = new InsTaishoSeitaiyinTempProcessMybatisParameter(shikibetsuTaishoPSMSearchKey);

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, para);

    }

    @Override
    protected void createWriter() {
        this.taiShoTableWriter = new BatchEntityCreatedTempTableWriter(tableName, TaishoSetaiinEntity.class);

    }

    @Override
    protected void process(InsTaishoSeitaiyinTempEntity entity) {
        TaishoSetaiinEntity taiShoEntity = new TaishoSetaiinEntity();
        SetaiShotokuEntity 世帯員所得情報一時 = entity.get世帯員所得情報一時();
        DbV1001HihokenshaDaichoEntity 被保険者台帳管理Newest = entity.get被保険者台帳管理Newest();
        taiShoEntity.setShoriNendo(parameter.get処理年度());
        taiShoEntity.setShotaikijunDay(parameter.get世帯員把握基準日());
        taiShoEntity.setShotaikijunDay2(parameter.get世帯員把握基準日2());
        taiShoEntity.setShotaiCode(getColumnValue(世帯員所得情報一時.getSetaiCode()));
        if (null != 被保険者台帳管理Newest.getKyuShichosonCode()) {
            taiShoEntity.setRannkuShichosonCode(getColumnValue(被保険者台帳管理Newest.getKyuShichosonCode()));
        } else if (null != 被保険者台帳管理Newest.getKoikinaiTokureiSochimotoShichosonCode()) {
            taiShoEntity.setRannkuShichosonCode(getColumnValue(被保険者台帳管理Newest.getKoikinaiTokureiSochimotoShichosonCode()));
        } else {
            taiShoEntity.setRannkuShichosonCode(getColumnValue(被保険者台帳管理Newest.getShichosonCode()));
        }
        taiShoEntity.setHihokenshaNo(entity.get被保険者台帳管理Newest().getHihokenshaNo());
        taiShoEntity.setShikibetsuCode(世帯員所得情報一時.getShikibetsuCode());
        taiShoEntity.setKazeiKubun(世帯員所得情報一時.getKazeiKubunGemmenGo());
        taiShoEntity.setKazeiShotokuGaku(世帯員所得情報一時.getKazeiShotokuGaku());

        taiShoEntity.setNenkinShunyuGaku(世帯員所得情報一時.getNenkiniShunyuGaku());

        if (getDecimal(世帯員所得情報一時.getNenkiniShotokuGaku()).compareTo(getDecimal(世帯員所得情報一時.getGokeiShotokuGaku())) <= 0) {
            taiShoEntity.setSonotanoGoukeiShotokuKingakuGoukei(
                    getDecimal(世帯員所得情報一時.getGokeiShotokuGaku()).subtract(getDecimal(世帯員所得情報一時.getNenkiniShotokuGaku())));
        } else {
            taiShoEntity.setSonotanoGoukeiShotokuKingakuGoukei(Decimal.ZERO);
        }

        taiShoEntity.setAtenaInnjiKubun(RSTRING_2);
        if (null != entity.get宛名情報()) {
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名情報());
            this.editTaishoSetaiin(taiShoEntity, 宛名);
        }
        this.taiShoTableWriter.insert(taiShoEntity);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private void editTaishoSetaiin(TaishoSetaiinEntity taiShoEntity, IKojin 宛名) {

        taiShoEntity.setSeinengappiYMD(宛名.get生年月日().toFlexibleDate());
        if (RSTRING_1.equals(parameter.get処理区分())) {
            taiShoEntity.setHihokenshaName(getColumnValue(宛名.get名称().getName()));
            taiShoEntity.setHihokenshaKana(getColumnValue(宛名.get名称().getKana()));
            taiShoEntity.setSex(宛名.get性別().getCommonName());
            AgeCalculator ageCalculator = new AgeCalculator(宛名.get生年月日(), JuminJotai.住民, FlexibleDate.MAX, parameter.get世帯員把握基準日());
            taiShoEntity.setAge(ageCalculator.get年齢());
            if (宛名.is住民() && 宛名.is日本人()) {
                taiShoEntity.setAtenaDateDhubetsu_kijunDay(RSTRING_10);
            } else if (宛名.is住民() && 宛名.is外国人()) {
                taiShoEntity.setAtenaDateDhubetsu_kijunDay(RSTRING_20);
            } else {
                taiShoEntity.setAtenaDateDhubetsu_kijunDay(RString.EMPTY);
            }

        } else if (RSTRING_2.equals(parameter.get処理区分())) {

            taiShoEntity.setHennshuuZokugaraCode(宛名.get続柄コードリスト().toTsuzukigaraCode().value());
            AgeCalculator ageCalculator = new AgeCalculator(宛名.get生年月日(), JuminJotai.住民, FlexibleDate.MAX, parameter.get世帯員把握基準日2());
            taiShoEntity.setAge(ageCalculator.get年齢());
            if (宛名.is住民() && 宛名.is日本人()) {
                taiShoEntity.setAtenaDateDhubetsu_1231(RSTRING_10);
            } else if (宛名.is住民() && 宛名.is外国人()) {
                taiShoEntity.setAtenaDateDhubetsu_1231(RSTRING_20);
            } else {
                taiShoEntity.setAtenaDateDhubetsu_1231(RString.EMPTY);
            }
        }

    }

    private Decimal getDecimal(Decimal decimal) {
        if (null != decimal) {
            return decimal;
        }
        return Decimal.ZERO;
    }

}
