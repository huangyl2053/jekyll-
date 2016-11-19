/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120140.ShikyuFushikyuKozaMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120140.ShikyuFushikyuMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu.ShikyuFushikyuKetteiKozaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shikyufushikyu.IShikyuFushikyuInMapper;
import jp.co.ndensan.reams.ua.uax.batchcontroller.base.KozaTorokuProcessBase;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaKihon;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaKihonBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.KozaHyojiKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.KozaYotoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaTorokuKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.kamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連から渡された口座情報（高額合算支給不支給決定一時TBLの口座情報）が口座マスタに登録されているか確認する。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
public class ShikyuFushikyuKozaKakuninTorokuProcess extends KozaTorokuProcessBase<ShikyuFushikyuKetteiKozaEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper"
            + ".relate.shikyufushikyu.IShikyuFushikyuInMapper.get口座登録");
    private static final RString ゆうちょコード = new RString("9900");
    private static final RString 口座種目_当座 = new RString("2");
    private static final int INT_0 = 0;
    private static final int INT_2 = 2;
    private static final RString 文字0 = new RString(0);
    private static final RString 文字1 = new RString(1);
    private static final RString 文字8 = new RString(8);
    private static final RString 文字9 = new RString(9);

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算支給不支給決定一時tableWriter;
    private static final RString 高額合算支給不支給決定一時_TABLE_NAME
            = new RString("DbWT38B1KogakuGassanShikyuFushikyuKettei");

    private ShikyuFushikyuKozaMyBatisParameter kozaParameter;
    private FlexibleDate now;
    private RString 主キー;

    @Override
    protected void initialize() {
        IShikyuFushikyuInMapper mapper = getMapper(IShikyuFushikyuInMapper.class);
        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
        IShunoKamoku 介護給付_高額合算 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護給付_高額合算);
        ShikyuFushikyuMyBatisParameter mybatisParameter = new ShikyuFushikyuMyBatisParameter();
        mybatisParameter.set科目コード(介護給付_高額合算.getコード());
        主キー = mapper.get業務別主キー(mybatisParameter);
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder()
                .set業務コード(GyomuCode.DB介護保険)
                .setサブ業務コード(SubGyomuCode.DBC介護給付)
                .set科目コード(介護給付_高額合算.getコード())
                .set業務別主キー(主キー)
                .set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振込口座.getCode()))
                .set基準日(FlexibleDate.getNowDate()).build();
        List<KamokuCode> kamokuList = new ArrayList<>();
        kamokuList.add(介護給付_高額合算.getコード());
        kozaParameter
                = new ShikyuFushikyuKozaMyBatisParameter(searchKey, kamokuList);
        now = FlexibleDate.getNowDate();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, kozaParameter);
    }

    @Override
    protected void createWriterInheritance() {
        高額合算支給不支給決定一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算支給不支給決定一時_TABLE_NAME,
                        DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    @Override
    protected void process(ShikyuFushikyuKetteiKozaEntity entity) {
        DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity 支給不支給決定 = entity.get支給不支給決定();
        DbWT0001HihokenshaTempEntity 被保険者 = entity.get被保険者();
        TokuteiKozaRelateEntity 口座 = entity.get口座();
        if (null != 口座) {
            支給不支給決定.set口座ID(口座.getUaT0310KozaEntity().getKozaId());
            高額合算支給不支給決定一時tableWriter.update(支給不支給決定.toEntity());
        } else {
            KozaKihonBuilder builder = getKozaKihonBuilder();
            set編集後口座ビルド(builder, 支給不支給決定, 被保険者);
            KozaKihon kihon = builder.build();
            save(kihon);
            支給不支給決定.set口座ID(kihon.get口座ID());
            高額合算支給不支給決定一時tableWriter.update(支給不支給決定.toEntity());
        }
    }

    private void set編集後口座ビルド(KozaKihonBuilder builder,
            DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity 支給不支給決定, DbWT0001HihokenshaTempEntity 被保険者) {
        builder.set口座名義人(new AtenaKanaMeisho(支給不支給決定.get口座名義人_カナ()));
        builder.set口座名義人漢字(AtenaMeisho.EMPTY);
        builder.set口座名義人識別コード(new ShikibetsuCode(被保険者.get識別コード()));
        builder.set口座振替通知書発行済フラグ(false);
        builder.set口座番号(支給不支給決定.get口座番号());
        builder.set口座登録区分(new KozaTorokuKubunCodeValue(new RString(1)));
        builder.set口座登録年月日(now);
        builder.set口座登録番号(RString.EMPTY);
        builder.set口座終了受付年月日(FlexibleDate.EMPTY);
        builder.set口座表示区分(KozaHyojiKubun.個別設定なし.getCode());
        builder.set口座開始受付年月日(now);
        builder.set名寄区分(false);
        builder.set有効終了年月日(FlexibleDate.MAX);
        builder.set有効開始年月日(now);
        builder.set検索用名義人(new AtenaKanaMeisho(支給不支給決定.get口座名義人_カナ()));
        builder.set業務別主キー(主キー);
        builder.set業務固有キー(RString.EMPTY);
        builder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振込口座.getCode()));
        builder.set登録連番(1);
        if (!RString.isNullOrEmpty(被保険者.get識別コード())) {
            builder.set識別コード(new ShikibetsuCode(被保険者.get識別コード()));
        } else {
            builder.set識別コード(ShikibetsuCode.EMPTY);
        }
        if (ゆうちょコード.equals(支給不支給決定.get金融機関コード())
                && !RString.isNullOrEmpty(支給不支給決定.get金融機関支店コード())) {
            RString 口座種目 = 支給不支給決定.get口座種目();
            if (口座種目_当座.equals(口座種目)) {
                builder.set店番(支給不支給決定.get金融機関支店コード().substring(INT_0, INT_2).concat(文字9));
                builder.set通帳記号(文字0.concat(支給不支給決定.get金融機関支店コード()).concat(文字0));
            } else {
                builder.set店番(支給不支給決定.get金融機関支店コード().substring(INT_0, INT_2).concat(文字8));
                builder.set通帳記号(文字1.concat(支給不支給決定.get金融機関支店コード()).concat(文字0));
            }
        }
        builder.set金融機関コード(new KinyuKikanCode(支給不支給決定.get金融機関コード()));
        if (ゆうちょコード.equals(支給不支給決定.get金融機関コード())) {
            builder.set通帳番号(支給不支給決定.get口座番号());
        } else {
            builder.set金融機関支店コード(new KinyuKikanShitenCode(支給不支給決定.get金融機関支店コード()));
            RString 口座種目 = 支給不支給決定.get口座種目();
            builder.set預金種別(口座種目);
        }
        builder.set領収済通知書発行要否(false);
    }

}
