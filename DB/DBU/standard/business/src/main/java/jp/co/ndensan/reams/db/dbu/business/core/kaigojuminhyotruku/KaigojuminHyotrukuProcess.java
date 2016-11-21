/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyotruku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojuminhyotruku.KaigojuminHyotrukuProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoChushutsuKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JutogaiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * バッチ設計_DBUMN81001_住民異動連携情報登録【他社住基用】クラスです。
 *
 * @reamsid_L DBA-1400-020 wanghui
 */
public class KaigojuminHyotrukuProcess {

    private static final RString 連番用 = new RString("0");
    private static final int 桁目_3 = 4;

    /**
     *
     * @param 抽出開始日時 RDateTime
     * @return keyBuilder
     */
    public ShikibetsuTaishoIdoSearchKeyBuilder 宛名識別対象異動分取得PSM(RDateTime 抽出開始日時) {
        if (抽出開始日時 == null) {
            抽出開始日時 = new YMDHMS(DbBusinessConfig.get(ConfigNameDBU.介護保険法情報_介護保険施行日,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).concat(new RString("000000"))).getRDateTime();
        }
        ShikibetsuTaishoIdoSearchKeyBuilder keyBuilder = new ShikibetsuTaishoIdoSearchKeyBuilder(
                ShikibetsuTaishoIdoChushutsuKubun.異動処理日時と異動事由で異動前後を抽出,
                抽出開始日時, RDate.getNowDateTime());
        List<JukiIdoJiyu> juminShubetsu = new ArrayList<>();
        juminShubetsu.add(JukiIdoJiyu.転入);
        juminShubetsu.add(JukiIdoJiyu.第30条の46届出);
        juminShubetsu.add(JukiIdoJiyu.特例による転入);
        juminShubetsu.add(JukiIdoJiyu.附則第5条届出);
        juminShubetsu.add(JukiIdoJiyu.第30条の47届出);
        juminShubetsu.add(JukiIdoJiyu.転出);
        juminShubetsu.add(JukiIdoJiyu.特例による転出);
        juminShubetsu.add(JukiIdoJiyu.死亡);
        juminShubetsu.add(JukiIdoJiyu.特殊修正);
        juminShubetsu.add(JukiIdoJiyu.履歴修正);
        juminShubetsu.add(JukiIdoJiyu.異動取消);
        juminShubetsu.add(JukiIdoJiyu.転居);
        juminShubetsu.add(JukiIdoJiyu.職権修正);
        juminShubetsu.add(JukiIdoJiyu.戸籍照合修正);
        juminShubetsu.add(JukiIdoJiyu.転入通知受理);
        juminShubetsu.add(JukiIdoJiyu.婚姻);
        juminShubetsu.add(JukiIdoJiyu.離婚);
        juminShubetsu.add(JukiIdoJiyu.養子縁組);
        juminShubetsu.add(JukiIdoJiyu.養子離縁);
        juminShubetsu.add(JukiIdoJiyu.転籍);
        juminShubetsu.add(JukiIdoJiyu.分籍);
        juminShubetsu.add(JukiIdoJiyu.入籍);
        juminShubetsu.add(JukiIdoJiyu.認知);
        juminShubetsu.add(JukiIdoJiyu.戸籍その他);
        juminShubetsu.add(JukiIdoJiyu.通称の記載);
        juminShubetsu.add(JukiIdoJiyu.通称の削除);
        juminShubetsu.add(JukiIdoJiyu.戸籍届出以外による婚姻);
        List<JutogaiIdoJiyu> jutogaiIdoJiyu = new ArrayList<>();
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.住基異動者追加);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.住民種別変更);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.修正);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.優先氏名変更);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.削除);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.削除回復);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.履歴修正);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.履歴削除);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.新規追加);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.物理削除);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.誤謬修正);
        keyBuilder.set個人のみ取得区分(true);
        keyBuilder.set住基異動事由コードList(juminShubetsu);
        keyBuilder.set住登外異動事由コードList(jutogaiIdoJiyu);
        return keyBuilder;
    }

    /**
     *
     * @param processParameter KaigojuminHyotrukuProcessParameter
     * @param dateentity DbT7022ShoriDateKanriEntity
     * @param 処理日時 RDateTime
     * @param shichosonCode RString
     * @return entity
     */
    public DbT7022ShoriDateKanriEntity データ更新(KaigojuminHyotrukuProcessParameter processParameter,
            RDateTime 処理日時, DbT7022ShoriDateKanriEntity dateentity, RString shichosonCode) {
        processParameter.setShoriTimestamp(YMDHMS.now().getRDateTime());
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
        entity.setShichosonCode(new LasdecCode(shichosonCode));
        entity.setShoriEdaban(new RString(String.valueOf(Integer.valueOf(dateentity.getShoriEdaban().toString()) + 1)).padLeft(連番用, 桁目_3));
        entity.setNendoNaiRenban(new RString(String.valueOf(Integer.valueOf(dateentity.getNendoNaiRenban().toString()) + 1)).padLeft(連番用, 桁目_3));
        entity.setShoriName(ShoriName.住民異動連携情報登録_他社住基用.get名称());
        entity.setNendo(new FlexibleYear("0000"));
        entity.setKijunYMD(new FlexibleDate(processParameter.getShoriTimestamp().getDate().toString()));
        entity.setKijunTimestamp(new YMDHMS(処理日時));
        entity.setTaishoKaishiYMD(new FlexibleDate(processParameter.getShoriTimestamp().getDate().toString()));
        entity.setTaishoShuryoYMD(new FlexibleDate(処理日時.getDate().toString()));
        entity.setTaishoKaishiTimestamp(new YMDHMS(processParameter.getShoriTimestamp()));
        RStringBuilder 日時 = new RStringBuilder();
        日時.append(処理日時.getDate());
        日時.append(処理日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        entity.setTaishoShuryoTimestamp(new YMDHMS(日時.toString().replace(":", "")));
        return entity;
    }

    /**
     *
     * @param processParameter KaigojuminHyotrukuProcessParameter
     * @param dateentity DbT7022ShoriDateKanriEntity
     * @param 処理日時 RDateTime
     * @param shichosonCode RString
     * @return entity
     */
    public DbT7022ShoriDateKanriEntity データ編集(KaigojuminHyotrukuProcessParameter processParameter,
            RDateTime 処理日時, DbT7022ShoriDateKanriEntity dateentity, RString shichosonCode) {
        processParameter.setShoriTimestamp(YMDHMS.now().getRDateTime());
        dateentity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
        dateentity.setShichosonCode(new LasdecCode(shichosonCode));
        dateentity.setShoriEdaban(new RString("0001"));
        dateentity.setNendoNaiRenban(new RString("0001"));
        dateentity.setShoriName(ShoriName.住民異動連携情報登録_他社住基用.get名称());
        dateentity.setNendo(new FlexibleYear("0000"));
        dateentity.setKijunYMD(new FlexibleDate(processParameter.getShoriTimestamp().getDate().toString()));
        dateentity.setKijunTimestamp(new YMDHMS(処理日時));
        dateentity.setTaishoKaishiYMD(new FlexibleDate(processParameter.getShoriTimestamp().getDate().toString()));
        dateentity.setTaishoShuryoYMD(new FlexibleDate(処理日時.getDate().toString()));
        dateentity.setTaishoKaishiTimestamp(new YMDHMS(processParameter.getShoriTimestamp()));
        RStringBuilder 日時 = new RStringBuilder();
        日時.append(処理日時.getDate());
        日時.append(処理日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        dateentity.setTaishoShuryoTimestamp(new YMDHMS(日時.toString().replace(":", "")));
        return dateentity;
    }
}
