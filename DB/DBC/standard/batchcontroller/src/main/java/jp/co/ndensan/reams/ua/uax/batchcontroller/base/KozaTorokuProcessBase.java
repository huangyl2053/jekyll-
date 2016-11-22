package jp.co.ndensan.reams.ua.uax.batchcontroller.base;

import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaKihon;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaKihonBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaRuiseki;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.IdoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.IdoZengoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SaibanKeysKoza;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0310KozaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0312KozaRuisekiEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 口座登録基本クラス
 *
 * @param <T>
 * @reamsid_L DBC-2690-010 zhangrui
 */
public abstract class KozaTorokuProcessBase<T> extends BatchProcessBase<T> {

    @BatchWriter
    private IBatchTableWriter kozaWriter;
    @BatchWriter
    private IBatchTableWriter kozaRuisekiWriter;

    @Override
    protected final void createWriter() {
        this.kozaWriter = BatchWriters.batchPermanentTableWriter(UaT0310KozaEntity.class).build();
        this.kozaRuisekiWriter = BatchWriters.batchPermanentTableWriter(UaT0312KozaRuisekiEntity.class).build();
        createWriterInheritance();
    }

    /**
     * createWriterInheritance
     */
    protected abstract void createWriterInheritance();

    /**
     * 口座を保存する。
     *
     * @param 口座基本情報 KozaKihon
     */
    protected void save(KozaKihon 口座基本情報) {
        if (口座基本情報 == null) {
            return;
        }
        if (口座基本情報.hasChanged()) {
            KozaRuiseki 累積 = 口座基本情報.to口座累積(RDateTime.now(), IdoZengoKubunType.異動後.code(), IdoKubunType.追加.code());
            this.kozaWriter.insert(口座基本情報.toEntity());
            this.kozaRuisekiWriter.insert(累積.toEntity());
        }
    }

    /**
     *
     * @return KozaKihonBuilder
     */
    protected KozaKihonBuilder getKozaKihonBuilder() {
        long 口座ID = Saiban.get(SubGyomuCode.UAX宛名公開, new RString(SaibanKeysKoza.口座ID.toString())).next();
        KozaKihon 口座基本情報 = new KozaKihon(口座ID);
        KozaKihonBuilder builder = 口座基本情報.createBuilderForEdit();
        builder.set口座振替通知書発行済フラグ(false);
        builder.set口座登録番号(RString.EMPTY);
        builder.set口座終了受付年月日(FlexibleDate.EMPTY);
        builder.set名寄区分(false);
        builder.set店番(RString.EMPTY);
        builder.set有効終了年月日(FlexibleDate.MAX);
        builder.set業務固有キー(RString.EMPTY);
        builder.set登録連番(1);
        builder.set通帳番号(RString.EMPTY);
        builder.set通帳記号(RString.EMPTY);
        builder.set金融機関支店コード(KinyuKikanShitenCode.EMPTY);
        builder.set預金種別(RString.EMPTY);
        builder.set領収済通知書発行要否(true);
        return builder;
    }
}
