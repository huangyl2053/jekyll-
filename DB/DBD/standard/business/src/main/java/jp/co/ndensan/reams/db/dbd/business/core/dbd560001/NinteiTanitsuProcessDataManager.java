/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd560001;

import static java.lang.String.format;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.YokaigoInterfaceIchoTorikomi;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd560001.NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd560001.YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.Datakubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定データ一括更新のDataのEditクラスです。
 *
 * @reamsid_L DBD-2120-020 liuwei2
 */
public class NinteiTanitsuProcessDataManager {

    private int 月数;
    private final RString 支1 = new RString("12");
    private final RString 支2 = new RString("13");
    private final RString 介1 = new RString("21");
    private final RString 介2 = new RString("22");
    private final RString 介3 = new RString("23");
    private final RString 介4 = new RString("24");
    private final RString 介5 = new RString("25");
    private static final Code CODE_ONE = new Code("1");
    private static final Code CODE_TWO = new Code("2");
    private static final Code CODE_THREE = new Code("3");
    private final RString 主治医のみ = YokaigoInterfaceIchoTorikomi.主治医のみ.getコード();
    private final RString 調査員のみ = YokaigoInterfaceIchoTorikomi.調査員のみ.getコード();
    private final RString 両方取込む = YokaigoInterfaceIchoTorikomi.両方取込む.getコード();

    /**
     * コンストラクタです。
     */
    public NinteiTanitsuProcessDataManager() {
    }

    /**
     * 受給者台帳Detail1を設定します。
     *
     * @param entity NinteiKekkaJohoEntity
     * @param 認定日 FlexibleDate
     * @return DbT4001JukyushaDaichoEntity
     */
    public DbT4001JukyushaDaichoEntity set受給者台帳Detail(NinteiKekkaJohoEntity entity, FlexibleDate 認定日) {
        entity.get受給者台帳Entity().setRirekiNo(new RString(format("%04d",
                Integer.valueOf(entity.get受給者台帳Entity().getRirekiNo().toString().replaceFirst("^0*", "")) + 1)));
        RString 受給申請事由 = entity.get受給者台帳Entity().getJukyuShinseiJiyu().value();
        if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(受給申請事由) || JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(受給申請事由)) {
            entity.get受給者台帳Entity().setShinseiJokyoKubun(ShinseiJokyoKubun.認定完了.getコード());
        }
        entity.get受給者台帳Entity().setChokkinFlag(true);

        entity.get受給者台帳Entity().setYokaigoJotaiKubunCode(new Code(entity.get二次判定要介護状態区分コード()));
        entity.get受給者台帳Entity().setNinteiYukoKikanKaishiYMD(entity.get二次判定認定有効開始年月日());
        entity.get受給者台帳Entity().setNinteiYukoKikanShuryoYMD(entity.get二次判定認定有効終了年月日());
        entity.get受給者台帳Entity().setNinteiYMD(認定日);

        if (CODE_ONE.equals(entity.get要介護認定申請情報Entity().getNinteiShinseiHoreiKubunCode())
                && CODE_TWO.equals(entity.get要介護認定申請情報Entity().getNinteiShinseiShinseijiKubunCode())) {
            entity.get受給者台帳Entity().setMinashiCode(CODE_ONE);
        } else {
            entity.get受給者台帳Entity().setMinashiCode(new Code("0"));
        }
        entity.get受給者台帳Entity().setChokkinIdoYMD(FlexibleDate.getNowDate());
        entity.get受給者台帳Entity().setChokkinIdoJiyuCode(new Code(ChokkinIdoJiyuCode.追加_認定.getコード()));
        entity.get受給者台帳Entity().setYukoMukoKubun(new Code(YukoMukoKubun.有効.getコード()));
        entity.get受給者台帳Entity().setDataKubun(new Code(Datakubun.通常_認定.getコード()));
        entity.get受給者台帳Entity().setRemban(entity.get受給者台帳Entity().getRirekiNo());
        return entity.get受給者台帳Entity();
    }

    /**
     * 受給者台帳Detail2を設定します。
     *
     * @param entity YokaigoNinteiInterfaceEntity
     * @param 認定日 FlexibleDate
     * @return DbT4001JukyushaDaichoEntity
     */
    public DbT4001JukyushaDaichoEntity upDate受給者台帳Detial(YokaigoNinteiInterfaceEntity entity, FlexibleDate 認定日) {
        RString rirekNo = entity.get受給者台帳Entity().getRirekiNo();
        entity.get受給者台帳Entity().setRirekiNo(new RString(format("%04d",
                Integer.valueOf(rirekNo.toString().replaceFirst("^0*", "")) + 1)));
        RString 受給申請事由 = entity.get受給者台帳Entity().getJukyuShinseiJiyu().value();
        if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(受給申請事由) || JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(受給申請事由)) {
            entity.get受給者台帳Entity().setShinseiJokyoKubun(ShinseiJokyoKubun.認定完了.getコード());
        }
        entity.get受給者台帳Entity().setChokkinFlag(true);

        entity.get受給者台帳Entity().setYokaigoJotaiKubunCode(new Code(entity.get二次判定結果()));
        entity.get受給者台帳Entity().setNinteiYukoKikanKaishiYMD(entity.get認定有効開始年月日());
        entity.get受給者台帳Entity().setNinteiYukoKikanShuryoYMD(entity.get認定有効終了年月日());
        entity.get受給者台帳Entity().setNinteiYMD(認定日);

        if (CODE_THREE.value().equals(entity.get申請種別コード()) && CODE_TWO.value().equals(entity.get予備区分4())) {
            entity.get受給者台帳Entity().setMinashiCode(CODE_ONE);
        } else {
            entity.get受給者台帳Entity().setMinashiCode(new Code("0"));
        }
        entity.get受給者台帳Entity().setChokkinIdoYMD(FlexibleDate.getNowDate());
        entity.get受給者台帳Entity().setChokkinIdoJiyuCode(new Code(ChokkinIdoJiyuCode.追加_認定.getコード()));
        entity.get受給者台帳Entity().setYukoMukoKubun(new Code(YukoMukoKubun.有効.getコード()));
        entity.get受給者台帳Entity().setDataKubun(new Code(Datakubun.通常_認定.getコード()));
        entity.get受給者台帳Entity().setRemban(entity.get受給者台帳Entity().getRirekiNo());
        return entity.get受給者台帳Entity();
    }

    /**
     * 要介護認定更新比較結果を設定します。
     *
     * @param 前回の要介護度 RString
     * @param 今回の要介護度 RString
     * @return state boolean
     */
    public boolean set要介護認定更新比較結果1(RString 前回の要介護度, RString 今回の要介護度) {
        if (前回の要介護度 != null && 前回の要介護度.equals(支1) && (今回の要介護度 != null && get今回の要介護度支1State(今回の要介護度))) {
            return true;
        }
        if (前回の要介護度 != null && 前回の要介護度.equals(支2) && (今回の要介護度 != null && get今回の要介護度支2State(今回の要介護度))) {
            return true;
        }
        if (前回の要介護度 != null && 前回の要介護度.equals(介1) && (今回の要介護度 != null && get今回の要介護度介1State(今回の要介護度))) {
            return true;
        }
        if (前回の要介護度 != null && 前回の要介護度.equals(介2) && (今回の要介護度 != null && get今回の要介護度介2State(今回の要介護度))) {
            return true;
        }
        return set要介護認定更新比較結果2(前回の要介護度, 今回の要介護度);
    }

    /**
     * 医調取込み情報厚労省を設定します。
     *
     * @param entity YokaigoNinteiInterfaceEntity
     * @param configValue_医調取込み情報 RString
     * @return entity YokaigoNinteiInterfaceEntity
     */
    public YokaigoNinteiInterfaceEntity set医調取込み情報厚労省(YokaigoNinteiInterfaceEntity entity, RString configValue_医調取込み情報) {
        set医調取込み情報_主治医のみ(entity, configValue_医調取込み情報);
        set医調取込み情報_調査員のみ(entity, configValue_医調取込み情報);
        set医調取込み情報_両方取込む(entity, configValue_医調取込み情報);
        return entity;
    }

    /**
     * 医調取込み情報電算を設定します。
     *
     * @param entity YokaigoNinteiInterfaceEntity
     * @return entity YokaigoNinteiInterfaceEntity
     */
    public YokaigoNinteiInterfaceEntity set医調取込み情報電算(YokaigoNinteiInterfaceEntity entity) {
        entity.get要介護認定申請情報Entity().setShujiiIryokikanCode(entity.get医療機関コード());
        entity.get要介護認定申請情報Entity().setShujiiCode(entity.get主治医コード());
        entity.get要介護認定申請情報Entity().setNinteiChosaItakusakiCode(new ChosaItakusakiCode(entity.get調査委託先コード()));
        entity.get要介護認定申請情報Entity().setNinteiChosainCode(new ChosainCode(entity.get調査員コード()));
        return entity;
    }

    /**
     * upDate要介護認定結果情報。
     *
     * @param entity YokaigoNinteiInterfaceEntity
     * @return entity YokaigoNinteiInterfaceEntity
     */
    public YokaigoNinteiInterfaceEntity upDate要介護認定結果情報広域(YokaigoNinteiInterfaceEntity entity) {
        entity.get要介護認定結果情報Entity().setNijiHanteiYokaigoJotaiKubunCode(new Code(entity.get二次判定結果()));
        entity.get要介護認定結果情報Entity().setNijiHanteiNinteiYukoKaishiYMD(entity.get認定有効開始年月日());
        entity.get要介護認定結果情報Entity().setNijiHanteiNinteiYukoShuryoYMD(entity.get認定有効終了年月日());
        if (entity.get要介護認定結果情報Entity().getShinsakaiShiryoSakuseiYMD() == null) {
            entity.get要介護認定結果情報Entity().setShinsakaiShiryoSakuseiYMD(entity.get審査会資料作成年月日());
        }
        entity.get要介護認定結果情報Entity().setShinsakaiIken(entity.get審査会意見());
        return entity;
    }

    /**
     * 要介護認定結果情報を挿入します。
     *
     * @param entity YokaigoNinteiInterfaceEntity
     * @return newEntity DbT4102NinteiKekkaJohoEntity
     */
    public DbT4102NinteiKekkaJohoEntity insert要介護認定結果情報(YokaigoNinteiInterfaceEntity entity) {
        DbT4102NinteiKekkaJohoEntity newEntity = new DbT4102NinteiKekkaJohoEntity();
        newEntity.setShinseishoKanriNo(entity.get申請書管理番号());
        if (entity.get二次判定日() == null) {
            newEntity.setNijiHanteiYMD(FlexibleDate.EMPTY);
        } else {
            newEntity.setNijiHanteiYMD(entity.get二次判定日());
        }
        if (entity.get二次判定結果() == null) {
            newEntity.setNijiHanteiYokaigoJotaiKubunCode(Code.EMPTY);
        } else {
            newEntity.setNijiHanteiYokaigoJotaiKubunCode(new Code(entity.get二次判定結果()));
        }
        if (entity.get認定有効終了年月日() == null || entity.get認定有効終了年月日() == null) {
            月数 = 0;
        } else {
            月数 = entity.get認定有効終了年月日().getBetweenMonths(entity.get認定有効開始年月日());
            if (entity.get認定有効開始年月日().getDayValue() == 1) {
                月数++;
            }
        }

        newEntity.setNijiHanteiNinteiYukoKikan(月数);
        newEntity.setNijiHanteiNinteiYukoKaishiYMD(entity.get認定有効開始年月日());
        newEntity.setNijiHanteiNinteiYukoShuryoYMD(entity.get認定有効終了年月日());
        newEntity.setShinsakaiShiryoSakuseiYMD(entity.get審査会資料作成年月日());
        newEntity.setShinsakaiIken(entity.get審査会意見());
        return newEntity;
    }

    private void set医調取込み情報_主治医のみ(YokaigoNinteiInterfaceEntity entity, RString configValue_医調取込み情報) {
        if (configValue_医調取込み情報.equals(主治医のみ)) {
            entity.get要介護認定申請情報Entity().setShujiiIryokikanCode(entity.get医療機関コード());
            entity.get要介護認定申請情報Entity().setShujiiCode(entity.get主治医コード());
        }
    }

    private void set医調取込み情報_調査員のみ(YokaigoNinteiInterfaceEntity entity, RString configValue_医調取込み情報) {
        if (configValue_医調取込み情報.equals(調査員のみ)) {
            entity.get要介護認定申請情報Entity().setNinteiChosaItakusakiCode(new ChosaItakusakiCode(entity.get調査委託先コード()));
            entity.get要介護認定申請情報Entity().setNinteiChosainCode(new ChosainCode(entity.get調査員コード()));
        }
    }

    private void set医調取込み情報_両方取込む(YokaigoNinteiInterfaceEntity entity, RString configValue_医調取込み情報) {
        if (configValue_医調取込み情報.equals(両方取込む)) {
            entity.get要介護認定申請情報Entity().setShujiiIryokikanCode(entity.get医療機関コード());
            entity.get要介護認定申請情報Entity().setShujiiCode(entity.get主治医コード());
            entity.get要介護認定申請情報Entity().setNinteiChosaItakusakiCode(new ChosaItakusakiCode(entity.get調査委託先コード()));
            entity.get要介護認定申請情報Entity().setNinteiChosainCode(new ChosainCode(entity.get調査員コード()));
        }
    }

    private boolean set要介護認定更新比較結果2(RString 前回の要介護度, RString 今回の要介護度) {

        if (前回の要介護度 != null && 前回の要介護度.equals(介3) && (今回の要介護度 != null && get今回の要介護度介3State(今回の要介護度))) {
            return true;
        }
        if (前回の要介護度 != null && 前回の要介護度.equals(介4) && (今回の要介護度 != null && get今回の要介護度介4State(今回の要介護度))) {
            return true;
        }
        return 前回の要介護度 != null && 前回の要介護度.equals(介5) && (今回の要介護度 != null && get今回の要介護度介5State(今回の要介護度));
    }

    private boolean get今回の要介護度支1State(RString 今回の要介護度) {
        return 今回の要介護度.equals(支1) || 今回の要介護度.equals(支2)
                || 今回の要介護度.equals(介1);
    }

    private boolean get今回の要介護度支2State(RString 今回の要介護度) {
        return 今回の要介護度.equals(支1) || 今回の要介護度.equals(支2)
                || 今回の要介護度.equals(介1) || 今回の要介護度.equals(介2);
    }

    private boolean get今回の要介護度介1State(RString 今回の要介護度) {
        return 今回の要介護度.equals(支1) || 今回の要介護度.equals(支2)
                || 今回の要介護度.equals(介1) || 今回の要介護度.equals(介2) || 今回の要介護度.equals(介3);
    }

    private boolean get今回の要介護度介2State(RString 今回の要介護度) {
        return 今回の要介護度.equals(支2) || 今回の要介護度.equals(介1) || 今回の要介護度.equals(介2)
                || 今回の要介護度.equals(介3) || 今回の要介護度.equals(介4);
    }

    private boolean get今回の要介護度介3State(RString 今回の要介護度) {
        return 今回の要介護度.equals(介1) || 今回の要介護度.equals(介2) || 今回の要介護度.equals(介3)
                || 今回の要介護度.equals(介4) || 今回の要介護度.equals(介5);
    }

    private boolean get今回の要介護度介4State(RString 今回の要介護度) {
        return 今回の要介護度.equals(介2) || 今回の要介護度.equals(介3) || 今回の要介護度.equals(介4) || 今回の要介護度.equals(介5);
    }

    private boolean get今回の要介護度介5State(RString 今回の要介護度) {
        return 今回の要介護度.equals(介3) || 今回の要介護度.equals(介4) || 今回の要介護度.equals(介5);
    }

}
