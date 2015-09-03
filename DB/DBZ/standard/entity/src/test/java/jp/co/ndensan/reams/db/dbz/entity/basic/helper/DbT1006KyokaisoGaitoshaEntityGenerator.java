/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 境界層該当者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT1006KyokaisoGaitoshaEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_適用開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_適用終了年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_境界層措置決定年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_給付額減額記載解除フラグ = new RString("Data");
    public static final RString DEFAULT_標準負担額額該当フラグ = new RString("Data");
    public static final Decimal DEFAULT_標準負担軽減後負担額 = new Decimal(0);
    public static final RString DEFAULT_居住費等負担額減額該当フラグ = new RString("Data");
    public static final RString DEFAULT_居住費軽減後居室種類コード = new RString("Data");
    public static final Decimal DEFAULT_居住費軽減後負担額 = new Decimal(0);
    public static final RString DEFAULT_食費負担額減額該当フラグ = new RString("Data");
    public static final Decimal DEFAULT_食費軽減後負担額 = new Decimal(0);
    public static final RString DEFAULT_高額ｻｰﾋﾞｽ費上限額減額該当フラグ = new RString("Data");
    public static final Decimal DEFAULT_高額ｻｰﾋﾞｽ費減額後上限額 = new Decimal(0);
    public static final RString DEFAULT_保険料納付減額フラグ = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1006KyokaisoGaitoshaEntityGenerator() {
    }

    public static DbT1006KyokaisoGaitoshaEntity createDbT1006KyokaisoGaitoshaEntity() {
        DbT1006KyokaisoGaitoshaEntity entity = new DbT1006KyokaisoGaitoshaEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setTekiyoKaishiYMD(DEFAULT_適用開始年月日);
        entity.setTekiyoShuryoYMD(DEFAULT_適用終了年月日);
        entity.setKyokaisoSochiKetteiYMD(DEFAULT_境界層措置決定年月日);
        entity.setKyuufugakuGengakuKisaiKiajoFlag(DEFAULT_給付額減額記載解除フラグ);
        entity.setHyojunFutanGengakuGaitoFlag(DEFAULT_標準負担額額該当フラグ);
        entity.setHyojunFutanKeigengoFutangaku(DEFAULT_標準負担軽減後負担額);
        entity.setKyojuhinadoFutangakugengakuGaitoFlag(DEFAULT_居住費等負担額減額該当フラグ);
        entity.setKyojuhiKeigengoKyoshitsuShuruiCode(DEFAULT_居住費軽減後居室種類コード);
        entity.setKyojuhiKeigengoHutangaku(DEFAULT_居住費軽減後負担額);
        entity.setShokuhiKeigengoHutangakuGaitoFlag(DEFAULT_食費負担額減額該当フラグ);
        entity.setShokuhiKeigengoHutangaku(DEFAULT_食費軽減後負担額);
        entity.setKogakuServicehiJogengakuGengakuGaitoFlag(DEFAULT_高額ｻｰﾋﾞｽ費上限額減額該当フラグ);
        entity.setKogakuServicehiJogengakuGengakugoJogengaku(DEFAULT_高額ｻｰﾋﾞｽ費減額後上限額);
        entity.setHokenryoNofuGengakuFlag(DEFAULT_保険料納付減額フラグ);
        return entity;
    }
}
