/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd503001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.chohyoshuchiryokuyoshiseijyoho.ChohyoShuchiryokuyoShiseiJyohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd503001.ShinsaHanteiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 介護認定審査判定依頼一覧表Editorです。
 *
 * @reamsid_L DBD-1480-030 b_liuyang2
 */
public class ShinsaHanteiIraiIchiranhyoEditor implements IShinsaHanteiIraiIchiranhyoEditor {

    private final List<ChohyoShuchiryokuyoShiseiJyohoEntity> 帳票出力用申請情報Entityリスト;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票出力用申請情報Entityリスト List<ChohyoShuchiryokuyoShiseiJyohoEntity>
     * @param index int
     */
    public ShinsaHanteiIraiIchiranhyoEditor(List<ChohyoShuchiryokuyoShiseiJyohoEntity> 帳票出力用申請情報Entityリスト, int index) {
        this.帳票出力用申請情報Entityリスト = 帳票出力用申請情報Entityリスト;
        this.index = index;
    }

    @Override
    public ShinsaHanteiIraiIchiranhyoReportSource edit(ShinsaHanteiIraiIchiranhyoReportSource source) {
        setShinsaHanteiIraiIchiranhyo(source);
        return source;
    }

    private void setShinsaHanteiIraiIchiranhyo(ShinsaHanteiIraiIchiranhyoReportSource source) {
        source.printTimeStamp = get印刷日時();
        source.title = DbBusinessConfig.get(
                ConfigNameDBD.要介護認定_要支援認定審査判定依頼一覧表, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        ChohyoShuchiryokuyoShiseiJyohoEntity 帳票出力用申請情報Entity = 帳票出力用申請情報Entityリスト.get(index);
        source.cityName = 帳票出力用申請情報Entity.get保険者名称();
        source.hokenshaNo = 帳票出力用申請情報Entity.get証記載保険者番号();
        source.listIraiichiranhyo1_1 = new RString(String.valueOf(index + 1));
        source.listIraiichiranhyo1_2 = 帳票出力用申請情報Entity.get被保険者番号().value();
        source.listIraiichiranhyo3_1 = 帳票出力用申請情報Entity.get被保険者氏名();
        source.listIraiichiranhyo3_2 = 帳票出力用申請情報Entity.get被保険者氏名カナ();
        source.listIraiichiranhyo3_3 = 帳票出力用申請情報Entity.get住所();
        source.listIraiichiranhyo2_1 = 帳票出力用申請情報Entity.get生年月日().wareki().toDateString();
        RString 性別 = 帳票出力用申請情報Entity.get性別();
        RString 性別名称 = RString.EMPTY;
        if (null != 性別 && !性別.isEmpty()) {
            性別名称 = Seibetsu.toValue(性別).get名称();
        }
        source.listIraiichiranhyo2_2 = 性別名称;

        RString 認定申請区分_申請時コード = 帳票出力用申請情報Entity.get認定申請区分_申請時コード();
        RString 認定申請区分_申請時名称 = RString.EMPTY;
        if (null != 認定申請区分_申請時コード && !認定申請区分_申請時コード.isEmpty()) {
            認定申請区分_申請時名称 = new RString(
                    NinteiShinseiKubunShinsei.toValue(Integer.parseInt(認定申請区分_申請時コード.toString())).name());
        }
        source.listIraiichiranhyo2_3 = 認定申請区分_申請時名称;

        RString 被保険者区分コード = 帳票出力用申請情報Entity.get被保険者区分コード();
        RString 被保険者区分名称 = RString.EMPTY;
        if (null != 被保険者区分コード && !被保険者区分コード.isEmpty()) {
            被保険者区分名称 = HihokenshaKubunCode.toValue(被保険者区分コード).get名称();
        }
        source.listIraiichiranhyo2_4 = 被保険者区分名称;

        source.listIraiichiranhyo2_5 = 帳票出力用申請情報Entity.get認定申請年月日().wareki().toDateString();
        source.listIraiichiranhyo2_6 = 帳票出力用申請情報Entity.get前回要介護状態区分コード();
        source.listIraiichiranhyo2_7 = 帳票出力用申請情報Entity.get前回認定有効期間開始().wareki().toDateString();
        source.listIraiichiranhyo2_8 = 帳票出力用申請情報Entity.get前回認定有効期間終了().wareki().toDateString();
        //TODO被保険者情報はなんですか
//        source.listIraiichiranhyo2_9 =
        source.reportId = new RString("DBD503001");
    }

    private RString get印刷日時() {
        FlexibleDate システム日 = FlexibleDate.getNowDate();
        RTime システム日時 = RTime.now();
        RString 年月日 = システム日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        RString 時分秒 = システム日時.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        return 年月日.concat(時分秒);
    }

}
