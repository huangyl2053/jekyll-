/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd710040;

import jp.co.ndensan.reams.db.dbd.business.core.dbd710040.HanyoListRiyoshaFutanGakuGengakuBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolistriyoshafutangakugengaku.RiyoshaFutanGakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolistriyoshafutangakugengaku.RiyoshaFutanGakuGengakuEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hanyolist.HanyoListEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 汎用リスト出力(利用者負担額減免)_ＣＳＶ編集クラスです．
 *
 * @reamsid_L DBD-3950-030 panxiaobo
 */
public class HanyoListRiyoshaFutanGakuGengakuManageer {

    /**
     * HanyoListShiharaiHohoHenkoManagerのインスタンス化
     *
     * @return HanyoListShiharaiHohoHenkoManager
     */
    public static HanyoListRiyoshaFutanGakuGengakuManageer createInstance() {
        return InstanceProvider.create(HanyoListRiyoshaFutanGakuGengakuManageer.class);
    }

    /**
     * 連番ありCSV情報設定
     *
     * @param eucCsvEntity CSV情報設定情報
     * @param entity SQL取得結果情報
     * @param 地方公共団体情報 地方公共団体情報
     * @param 保険者リスト 保険者リスト
     * @param 日付スラッシュ付加 日付スラッシュ付加
     */
    public void CSV情報設定(RiyoshaFutanGakuGengakuEucCsvEntity eucCsvEntity, RiyoshaFutanGakuGengakuEntity entity,
            Association 地方公共団体情報, HokenshaList 保険者リスト, boolean 日付スラッシュ付加) {
        HanyoListRiyoshaFutanGakuGengakuBusiness bus = new HanyoListRiyoshaFutanGakuGengakuBusiness();
        bus.setEucCsvEntity(地方公共団体情報, 日付スラッシュ付加, eucCsvEntity, entity, 保険者リスト);
    }

    /**
     * ＣＳＶ情報
     *
     * @return RiyoshaFutanGakuGengakuEucCsvEntity eucCsvEntity
     */
    public RiyoshaFutanGakuGengakuEucCsvEntity setBlank() {
        HanyoListRiyoshaFutanGakuGengakuBusiness bus = new HanyoListRiyoshaFutanGakuGengakuBusiness();
        return bus.setNewBlank();
    }

    /**
     * ＣＳＶ情報
     *
     * @param entity
     * @param hanyolistentity
     *
     */
    public void get方法(RiyoshaFutanGakuGengakuEntity entity, HanyoListEntity hanyolistentity) {
        ChoikiCode 町域コード = entity.getPsmEntity().getChoikiCode();
        YubinNo 郵便番号 = entity.getPsmEntity().getYubinNo();
        AtenaBanchi 番地コード = entity.getPsmEntity().getBanchi();
        GyoseikuCode 行政区コード = entity.getPsmEntity().getGyoseikuCode();
        ChikuCode 地区１ = entity.getPsmEntity().getChikuCode1();
        ChikuCode 地区２ = entity.getPsmEntity().getChikuCode2();
        SetaiCode 世帯コード = entity.getPsmEntity().getSetaiCode();
        hanyolistentity.set郵便番号(郵便番号 != null ? 郵便番号.getYubinNo() : RString.EMPTY);
        hanyolistentity.set町域コード(町域コード != null ? 町域コード.getColumnValue() : RString.EMPTY);
        hanyolistentity.set番地コード(番地コード != null ? 番地コード.getColumnValue() : RString.EMPTY);
        hanyolistentity.set行政区コード(行政区コード != null ? 行政区コード.getColumnValue() : RString.EMPTY);
        hanyolistentity.set地区１(地区１ != null ? 地区１.getColumnValue() : RString.EMPTY);
        hanyolistentity.set地区２(地区２ != null ? 地区２.getColumnValue() : RString.EMPTY);
        hanyolistentity.set世帯コード(世帯コード != null ? 世帯コード.getColumnValue() : RString.EMPTY);
        hanyolistentity.set識別コード(entity.get被保険者台帳管理_識別コード());
        hanyolistentity.set氏名５０音カナ(entity.getPsmEntity().getKanaName());
        hanyolistentity.set生年月日(entity.getPsmEntity().getSeinengappiYMD());
        hanyolistentity.set性別(entity.getPsmEntity().getSeibetsuCode());
        hanyolistentity.set市町村コード(entity.get被保険者台帳管理_市町村コード());
        hanyolistentity.set証記載保険者番号(entity.get利用者負担額減額_証記載保険者番号());
        hanyolistentity.set被保険者番号(entity.get被保険者台帳管理_被保険者番号());
        hanyolistentity.set資格区分(entity.get被保険者台帳管理_被保険者区分コード());
        hanyolistentity.set認定開始日(entity.get前回受給情報_認定年月日());
        hanyolistentity.set資格取得日(entity.get被保険者台帳管理_資格取得年月日());
        hanyolistentity.set資格喪失日(entity.get被保険者台帳管理_資格喪失年月日());
        hanyolistentity.set受給申請区分(entity.get初回申請_要支援者認定申請区分());
        hanyolistentity.set受給申請日(entity.get受給者台帳_受給申請年月日());
        hanyolistentity.set要介護度(entity.get初回受給情報_みなし要介護区分コード());
    }
}
