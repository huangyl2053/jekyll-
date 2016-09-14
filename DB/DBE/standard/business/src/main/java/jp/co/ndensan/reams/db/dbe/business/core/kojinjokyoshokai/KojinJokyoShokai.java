/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.kojinjokyoshokai;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kojinjokyoshokai.KojinJokyoShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IIchijiHanteiKekkaCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaSupport;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 要介護認定個人状況を管理するクラスです。
 *
 * @reamsid_L DBE-0200-010 suguangjun
 */
public class KojinJokyoShokai {

    private final KojinJokyoShokaiRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link KojinJokyoShokaiRelateEntity}より{@link KojinJokyoShokai}を生成します。
     *
     * @param entity DBより取得した{@link KojinJokyoShokaiRelateEntity}
     */
    public KojinJokyoShokai(KojinJokyoShokaiRelateEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定個人状況照会情報"));
    }

    /**
     * 認定調査依頼予定年月日を返します。
     *
     * @return 認定調査依頼予定年月日
     */
    public FlexibleDate get認定調査依頼予定年月日() {
        return entity.getNinteichosaIraiYoteiYMD();
    }

    /**
     * 認定調査予定年月日を返します。
     *
     * @return 認定調査予定年月日
     */
    public FlexibleDate get認定調査予定年月日() {
        return entity.getNinteichosaYoteiYMD();
    }

    /**
     * 主治医意見書作成依頼予定年月日を返します。
     *
     * @return 主治医意見書作成依頼予定年月日
     */
    public FlexibleDate get主治医意見書作成依頼予定年月日() {
        return entity.getIkenshoSakuseiIraiYoteiYMD();
    }

    /**
     * 主治医意見書登録予定年月日を返します。
     *
     * @return 主治医意見書登録予定年月日
     */
    public FlexibleDate get主治医意見書登録予定年月日() {
        return entity.getIkenshoTorokuYoteiYMD();
    }

    /**
     * 要介護認定一次判定予定年月日を返します。
     *
     * @return 要介護認定一次判定予定年月日
     */
    public FlexibleDate get要介護認定一次判定予定年月日() {
        return entity.getIchijiHanteiYoteiYMD();
    }

    /**
     * 認定審査会割当予定年月日を返します。
     *
     * @return 認定審査会割当予定年月日
     */
    public FlexibleDate get認定審査会割当予定年月日() {
        return entity.getNinteiShinsakaiWariateYoteiYMD();
    }

    /**
     * 認定審査会予定年月日を返します。
     *
     * @return 認定審査会予定年月日
     */
    public FlexibleDate get認定審査会予定年月日() {
        return entity.getNinteiShinsakaiYoteiYMD();
    }

    /**
     * 認定調査依頼完了年月日を返します。
     *
     * @return 認定調査依頼完了年月日
     */
    public FlexibleDate get認定調査依頼完了年月日() {
        return entity.getNinteichosaIraiKanryoYMD();
    }

    /**
     * 認定調査完了年月日を返します。
     *
     * @return 認定調査完了年月日
     */
    public FlexibleDate get認定調査完了年月日() {
        return entity.getNinteichosaKanryoYMD();
    }

    /**
     * 主治医意見書作成依頼完了年月日を返します。
     *
     * @return 主治医意見書作成依頼完了年月日
     */
    public FlexibleDate get主治医意見書作成依頼完了年月日() {
        return entity.getIkenshoSakuseiIraiKanryoYMD();
    }

    /**
     * 主治医意見書登録完了年月日を返します。
     *
     * @return 主治医意見書登録完了年月日
     */
    public FlexibleDate get主治医意見書登録完了年月日() {
        return entity.getIkenshoTorokuKanryoYMD();
    }

    /**
     * 要介護認定一次判定完了年月日を返します。
     *
     * @return 要介護認定一次判定完了年月日
     */
    public FlexibleDate get要介護認定一次判定完了年月日() {
        return entity.getIchijiHanteiKanryoYMD();
    }

    /**
     * マスキング完了年月日を返します。
     *
     * @return マスキング完了年月日
     */
    public FlexibleDate getマスキング完了年月日() {
        return entity.getMaskingKanryoYMD();
    }

    /**
     * 認定審査会割当完了年月日を返します。
     *
     * @return 認定審査会割当完了年月日
     */
    public FlexibleDate get認定審査会割当完了年月日() {
        return entity.getNinteiShinsakaiWariateKanryoYMD();
    }

    /**
     * 認定審査会完了年月日を返します。
     *
     * @return 認定審査会完了年月日
     */
    public FlexibleDate get認定審査会完了年月日() {
        return entity.getNinteiShinsakaiKanryoYMD();
    }

    /**
     * 被保番号を返します。
     *
     * @return 被保番号
     */
    public RString get被保番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定申請区分申請時を返します。
     *
     * @return 認定申請区分申請時
     */
    public Code get認定申請区分申請時() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 認定申請区分法令時を返します。
     *
     * @return 認定申請区分法令時
     */
    public Code get認定申請区分法令時() {
        return entity.getNinteiShinseiHoreiKubunCode();
    }

    /**
     * 二次判定要介護状態区分コードを返します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public Code get二次判定要介護状態区分コード() {
        return entity.getNijiHanteiYokaigoJotaiKubunCode() == null ? Code.EMPTY : entity.getNijiHanteiYokaigoJotaiKubunCode();
    }

    /**
     * 二次判定結果の名称(要介護度)を返却します。
     *
     * @return 二次判定結果の名称
     */
    public RString get二次判定結果名称() {
        return YokaigoJotaiKubunSupport.toValueOrEmpty(
                get厚労省IF識別コード().value(), get二次判定要介護状態区分コード().value()
        ).getName();
    }

    /**
     * 二次判定認定有効開始年月日を返します。
     *
     * @return 二次判定認定有効開始年月日
     */
    public FlexibleDate get二次判定認定有効開始年月日() {
        return entity.getNijiHanteiNinteiYukoKaishiYMD();
    }

    /**
     * 二次判定認定有効終了年月日を返します。
     *
     * @return 二次判定認定有効終了年月日
     */
    public FlexibleDate get二次判定認定有効終了年月日() {
        return entity.getNijiHanteiNinteiYukoShuryoYMD();
    }

    /**
     * 二次判定認定有効期間を返します。
     *
     * @return 二次判定認定有効期間
     */
    public int get二次判定認定有効期間() {
        return entity.getNijiHanteiNinteiYukoKikan();
    }

    /**
     * 要支援申請の区分を返します。
     *
     * @return 要支援申請の区分
     */
    public RString get要支援申請の区分() {
        return entity.getShienShinseiKubun();
    }

    /**
     * 二号特定疾病コードを返します。
     *
     * @return 二号特定疾病コード
     */
    public Code get二号特定疾病コード() {
        return entity.getNigoTokuteiShippeiCode();
    }

    /**
     * 情報提供への同意有無を返します。
     *
     * @return 情報提供への同意有無
     */
    public boolean is情報提供への同意有無() {
        return entity.isJohoteikyoDoiFlag();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode() == null ? Code.EMPTY : entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 要介護認定一次判定結果コードを返します。
     *
     * @return 要介護認定一次判定結果コード
     */
    public Code get要介護認定一次判定結果コード() {
        return entity.getIchijiHanteiKekkaCode() == null ? Code.EMPTY : entity.getIchijiHanteiKekkaCode();
    }

    /**
     * 一次判定結果コードと認知症加算後のコードから、一次判定結果の名称を返却します。
     *
     * @return 一次判定結果
     */
    public RString get一次判定結果名称() {
        final RString koroshoIFCode = this.get厚労省IF識別コード().value();
        final RString kekkaCode = this.get要介護認定一次判定結果コード().value();
        final RString kasanCode = this.get要介護認定一次判定結果コード認知症加算().value();

        IIchijiHanteiKekkaCode kekkaName = IchijiHanteiKekkaSupport.toValueOrEmpty(koroshoIFCode, kekkaCode);
        if (Objects.equals(kekkaCode, kasanCode) || RString.isNullOrEmpty(kasanCode)) {
            return kekkaName.get名称();
        }
        IIchijiHanteiKekkaCode kasanName = IchijiHanteiKekkaSupport.toValueOrEmpty(koroshoIFCode, kasanCode);
        return new RStringBuilder().append(kekkaName.get略称()).append("→").append(kasanName.get略称()).toRString();
    }

    /**
     * 要介護認定一次判定結果コード認知症加算を返します。
     *
     * @return 要介護認定一次判定結果コード認知症加算
     */
    public Code get要介護認定一次判定結果コード認知症加算() {
        return entity.getIchijiHanteiKekkaNinchishoKasanCode() == null ? Code.EMPTY : entity.getIchijiHanteiKekkaNinchishoKasanCode();
    }

    /**
     * 審査会開催年月日を返します。
     *
     * @return 審査会開催年月日
     */
    public FlexibleDate get審査会開催年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 処理状態区分を返します。
     *
     * @return 処理状態区分
     */
    public Code get処理状態区分() {
        return entity.getShoriJotaiKubun();
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.getShujiiIryokikanCode();
    }

    /**
     * 医療機関名称を返します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.getShujiiName();
    }

    /**
     * 指定医フラグを返します。
     *
     * @return 指定医フラグ
     */
    public boolean is指定医フラグ() {
        return entity.isShiteiiFlag();
    }

    /**
     * 医師区分コードを返します。
     *
     * @return 医師区分コード
     */
    public Code get医師区分コード() {
        return entity.getIshiKubunCode();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 主治医氏名
     */
    public RString get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 市町村連絡事項を返します。
     *
     * @return 市町村連絡事項
     */
    public RString get市町村連絡事項() {
        return entity.getShichosonRenrakuJiko();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo() == null ? RString.EMPTY : entity.getHihokenshaNo();
    }

    /**
     * 認定申請区分（申請時）コードを取得します。
     *
     * @return 認定申請区分（申請時）コード
     */
    public Code get認定申請区分申請時コード() {
        return entity.getShinseiKubun() == null ? Code.EMPTY : entity.getShinseiKubun();
    }

    /**
     * 被保険者氏名カナを取得します。
     *
     * @return 被保険者氏名カナ
     */
    public RString get被保険者氏名カナ() {
        return entity.getHihokenshaNameKana();
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getShinseiYMD() == null ? FlexibleDate.EMPTY : entity.getShinseiYMD();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getBirthYMD() == null ? FlexibleDate.EMPTY : entity.getBirthYMD();
    }

    /**
     * 年齢を取得します。
     *
     * @return 年齢
     */
    public int get年齢() {
        return entity.getAge();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo1() == null ? YubinNo.EMPTY : entity.getYubinNo1();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getHihokenshaJusho() == null ? AtenaJusho.EMPTY : entity.getHihokenshaJusho();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo1() == null ? TelNo.EMPTY : entity.getTelNo1();
    }

    /**
     * 認定申請理由を取得します。
     *
     * @return 認定申請理由
     */
    public RString get認定申請理由() {
        return entity.getShinseiRiyu();
    }

    /**
     * 申請者氏名を取得します。
     *
     * @return 申請者氏名
     */
    public RString get申請者氏名() {
        return entity.getShinseishaName();
    }

    /**
     * 申請代行事業者を取得します。
     *
     * @return 申請代行事業者
     */
    public RString get申請代行事業者() {
        return entity.getShinseiDaikoJigyoshaName();
    }

    /**
     * 申請届出代行区分コードを取得します。
     *
     * @return 申請届出代行区分コード
     */
    public Code get申請届出代行区分コード() {
        return entity.getShinseishaKankei() == null ? Code.EMPTY : entity.getShinseishaKankei();
    }

    /**
     * 申請届出者続柄コードを取得します。
     *
     * @return 申請届出者続柄コード
     */
    public Code get申請届出者続柄コード() {
        return entity.getHonninKankei() == null ? Code.EMPTY : entity.getHonninKankei();
    }

    /**
     * 申請者郵便番号を取得します。
     *
     * @return 申請者郵便番号
     */
    public YubinNo get申請者郵便番号() {
        return entity.getYubinNo2() == null ? YubinNo.EMPTY : entity.getYubinNo2();
    }

    /**
     * 申請届出者住所を取得します。
     *
     * @return 申請届出者住所
     */
    public AtenaJusho get申請届出者住所() {
        return entity.getShinseishaJusho() == null ? AtenaJusho.EMPTY : entity.getShinseishaJusho();
    }

    /**
     * 申請届出者電話番号を取得します。
     *
     * @return 申請届出者電話番号
     */
    public TelNo get申請届出者電話番号() {
        return entity.getTelNo2() == null ? TelNo.EMPTY : entity.getTelNo2();
    }

    /**
     * 入所施設名を取得します。
     *
     * @return 入所施設名
     */
    public RString get入所施設名() {
        return entity.getShisetsuName();
    }

    /**
     * 入所施設所在地を取得します。
     *
     * @return 入所施設所在地
     */
    public AtenaJusho get入所施設所在地() {
        return entity.getShisetsujusho() == null ? AtenaJusho.EMPTY : entity.getShisetsujusho();
    }

    /**
     * 入所施設電話番号を取得します。
     *
     * @return 入所施設電話番号
     */
    public TelNo get入所施設電話番号() {
        return entity.getTelNo3() == null ? TelNo.EMPTY : entity.getTelNo3();
    }

    /**
     * 今回事業者名称を取得します。
     *
     * @return 今回事業者名称
     */
    public RString get今回事業者名称() {
        return entity.getChosain_1();
    }

    /**
     * 今回調査員氏名を取得します。
     *
     * @return 今回調査員氏名
     */
    public RString get今回調査員氏名() {
        return entity.getChosain_2();
    }

    /**
     * 今回調査員電話番号を取得します。
     *
     * @return 今回調査員電話番号
     */
    public TelNo get今回調査員電話番号() {
        return entity.getChosain_3() == null ? TelNo.EMPTY : entity.getChosain_3();
    }

    /**
     * 前回事業者名称を取得します。
     *
     * @return 前回事業者名称
     */
    public RString get前回事業者名称() {
        return entity.getChosain_4();
    }

    /**
     * 前回調査員氏名を取得します。
     *
     * @return 前回調査員氏名
     */
    public RString get前回調査員氏名() {
        return entity.getChosain_5();
    }

    /**
     * 前回調査員電話番号を取得します。
     *
     * @return 前回調査員電話番号
     */
    public TelNo get前回調査員電話番号() {
        return entity.getChosain_6() == null ? TelNo.EMPTY : entity.getChosain_6();
    }

    /**
     * 前々回事業者名称を取得します。
     *
     * @return 前々回事業者名称
     */
    public RString get前々回事業者名称() {
        return entity.getChosain_7();
    }

    /**
     * 前々回調査員氏名を取得します。
     *
     * @return 前々回調査員氏名
     */
    public RString get前々回調査員氏名() {
        return entity.getChosain_8();
    }

    /**
     * 前々回調査員電話番号を取得します。
     *
     * @return 前々回調査員電話番号
     */
    public TelNo get前々回調査員電話番号() {
        return entity.getChosain_9() == null ? TelNo.EMPTY : entity.getChosain_9();
    }

    /**
     * 今回医療機関名称を取得します。
     *
     * @return 今回医療機関名称
     */
    public RString get今回医療機関名称() {
        return entity.getShui_1();
    }

    /**
     * 今回主治医名を取得します。
     *
     * @return 今回主治医名
     */
    public RString get今回主治医名() {
        return entity.getShui_2();
    }

    /**
     * 今回主治医電話番号を取得します。
     *
     * @return 今回主治医電話番号
     */
    public TelNo get今回主治医電話番号() {
        return entity.getShui_3() == null ? TelNo.EMPTY : entity.getShui_3();
    }

    /**
     * 前回医療機関名称を取得します。
     *
     * @return 前回医療機関名称
     */
    public RString get前回医療機関名称() {
        return entity.getShui_4();
    }

    /**
     * 前回主治医名を取得します。
     *
     * @return 前回主治医名
     */
    public RString get前回主治医名() {
        return entity.getShui_5();
    }

    /**
     * 前回主治医電話番号を取得します。
     *
     * @return 前回主治医電話番号
     */
    public TelNo get前回主治医電話番号() {
        return entity.getShui_6() == null ? TelNo.EMPTY : entity.getShui_6();
    }

    /**
     * 前々回医療機関名称を取得します。
     *
     * @return 前々回医療機関名称
     */
    public RString get前々回医療機関名称() {
        return entity.getShui_7();
    }

    /**
     * 前々回主治医名を取得します。
     *
     * @return 前々回主治医名
     */
    public RString get前々回主治医名() {
        return entity.getShui_8();
    }

    /**
     * 前々回主治医電話番号を取得します。
     *
     * @return 前々回主治医電話番号
     */
    public TelNo get前々回主治医電話番号() {
        return entity.getShui_9() == null ? TelNo.EMPTY : entity.getShui_9();
    }

    /**
     * 今回申請情報登録完了年月日を取得します。
     *
     * @return 今回申請情報登録完了年月日
     */
    public FlexibleDate get今回申請情報登録完了年月日() {
        return entity.getKonnkai_1() == null ? FlexibleDate.EMPTY : entity.getKonnkai_1();
    }

    /**
     * 前回申請情報登録完了年月日を取得します。
     *
     * @return 前回申請情報登録完了年月日
     */
    public FlexibleDate get前回申請情報登録完了年月日() {
        return entity.getZennkai_1() == null ? FlexibleDate.EMPTY : entity.getZennkai_1();
    }

    /**
     * 前々回申請情報登録完了年月日を取得します。
     *
     * @return 前々回申請情報登録完了年月日
     */
    public FlexibleDate get前々回申請情報登録完了年月日() {
        return entity.getZennnoma_1() == null ? FlexibleDate.EMPTY : entity.getZennnoma_1();
    }

    /**
     * 今回調査依頼完了年月日を取得します。
     *
     * @return 今回調査依頼完了年月日
     */
    public FlexibleDate get今回調査依頼完了年月日() {
        return entity.getKonnkai_4() == null ? FlexibleDate.EMPTY : entity.getKonnkai_4();
    }

    /**
     * 前回調査依頼完了年月日を取得します。
     *
     * @return 前回調査依頼完了年月日
     */
    public FlexibleDate get前回調査依頼完了年月日() {
        return entity.getZennkai_4() == null ? FlexibleDate.EMPTY : entity.getZennkai_4();
    }

    /**
     * 前々回調査依頼完了年月日を取得します。
     *
     * @return 前々回調査依頼完了年月日
     */
    public FlexibleDate get前々回調査依頼完了年月日() {
        return entity.getZennnoma_4() == null ? FlexibleDate.EMPTY : entity.getZennnoma_4();
    }

    /**
     * 今回調査完了年月日を取得します。
     *
     * @return 今回調査完了年月日
     */
    public FlexibleDate get今回調査完了年月日() {
        return entity.getKonnkai_7() == null ? FlexibleDate.EMPTY : entity.getKonnkai_7();
    }

    /**
     * 前回調査完了年月日を取得します。
     *
     * @return 前回調査完了年月日
     */
    public FlexibleDate get前回調査完了年月日() {
        return entity.getZennkai_7() == null ? FlexibleDate.EMPTY : entity.getZennkai_7();
    }

    /**
     * 前々調査完了年月日を取得します。
     *
     * @return 前々調査完了年月日
     */
    public FlexibleDate get前々調査完了年月日() {
        return entity.getZennnoma_7() == null ? FlexibleDate.EMPTY : entity.getZennnoma_7();
    }

    /**
     * 今回意見書作成依頼完了年月日を取得します。
     *
     * @return 今回意見書作成依頼完了年月日
     */
    public FlexibleDate get今回意見書作成依頼完了年月日() {
        return entity.getKonnkai_10() == null ? FlexibleDate.EMPTY : entity.getKonnkai_10();
    }

    /**
     * 前回意見書作成依頼完了年月日を取得します。
     *
     * @return 前回意見書作成依頼完了年月日
     */
    public FlexibleDate get前回意見書作成依頼完了年月日() {
        return entity.getZennkai_10() == null ? FlexibleDate.EMPTY : entity.getZennkai_10();
    }

    /**
     * 前々回意見書作成依頼完了年月日を取得します。
     *
     * @return 前々回意見書作成依頼完了年月日
     */
    public FlexibleDate get前々回意見書作成依頼完了年月日() {
        return entity.getZennnoma_10() == null ? FlexibleDate.EMPTY : entity.getZennnoma_10();
    }

    /**
     * 今回意見書登録完了年月日を取得します。
     *
     * @return 今回意見書登録完了年月日
     */
    public FlexibleDate get今回意見書登録完了年月日() {
        return entity.getKonnkai_13() == null ? FlexibleDate.EMPTY : entity.getKonnkai_13();
    }

    /**
     * 前回意見書登録完了年月日を取得します。
     *
     * @return 前回意見書登録完了年月日
     */
    public FlexibleDate get前回意見書登録完了年月日() {
        return entity.getZennkai_13() == null ? FlexibleDate.EMPTY : entity.getZennkai_13();
    }

    /**
     * 前々回意見書登録完了年月日を取得します。
     *
     * @return 前々回意見書登録完了年月日
     */
    public FlexibleDate get前々回意見書登録完了年月日() {
        return entity.getZennnoma_13() == null ? FlexibleDate.EMPTY : entity.getZennnoma_13();
    }

    /**
     * 今回一次判定完了年月日を取得します。
     *
     * @return 今回一次判定完了年月日
     */
    public FlexibleDate get今回一次判定完了年月日() {
        return entity.getKonnkai_15() == null ? FlexibleDate.EMPTY : entity.getKonnkai_15();
    }

    /**
     * 前回一次判定完了年月日を取得します。
     *
     * @return 前回一次判定完了年月日
     */
    public FlexibleDate get前回一次判定完了年月日() {
        return entity.getZennkai_15() == null ? FlexibleDate.EMPTY : entity.getZennkai_15();
    }

    /**
     * 前々回一次判定完了年月日を取得します。
     *
     * @return 前々回一次判定完了年月日
     */
    public FlexibleDate get前々回一次判定完了年月日() {
        return entity.getZennnoma_15() == null ? FlexibleDate.EMPTY : entity.getZennnoma_15();
    }

    /**
     * 今回マスキング完了年月日を取得します。
     *
     * @return 今回マスキング完了年月日
     */
    public FlexibleDate get今回マスキング完了年月日() {
        return entity.getKonnkai_16() == null ? FlexibleDate.EMPTY : entity.getKonnkai_16();
    }

    /**
     * 前回マスキング完了年月日を取得します。
     *
     * @return 前回マスキング完了年月日
     */
    public FlexibleDate get前回マスキング完了年月日() {
        return entity.getZennkai_16() == null ? FlexibleDate.EMPTY : entity.getZennkai_16();
    }

    /**
     * 前々回マスキング完了年月日を取得します。
     *
     * @return 前々回マスキング完了年月日
     */
    public FlexibleDate get前々回マスキング完了年月日() {
        return entity.getZennnoma_16() == null ? FlexibleDate.EMPTY : entity.getZennnoma_16();
    }

    /**
     * 今回審査会割当完了年月日を取得します。
     *
     * @return 今回審査会割当完了年月日
     */
    public FlexibleDate get今回審査会割当完了年月日() {
        return entity.getKonnkai_19() == null ? FlexibleDate.EMPTY : entity.getKonnkai_19();
    }

    /**
     * 前回審査会割当完了年月日を取得します。
     *
     * @return 前回審査会割当完了年月日
     */
    public FlexibleDate get前回審査会割当完了年月日() {
        return entity.getZennkai_19() == null ? FlexibleDate.EMPTY : entity.getZennkai_19();
    }

    /**
     * 前々回審査会割当完了年月日を取得します。
     *
     * @return 前々回審査会割当完了年月日
     */
    public FlexibleDate get前々回審査会割当完了年月日() {
        return entity.getZennnoma_19() == null ? FlexibleDate.EMPTY : entity.getZennnoma_19();
    }

    /**
     * 今回審査会割当完了年月日を取得します。
     *
     * @return 今回審査会割当完了年月日
     */
    public FlexibleDate get今回審査会完了年月日() {
        return entity.getKonnkai_20() == null ? FlexibleDate.EMPTY : entity.getKonnkai_20();
    }

    /**
     * 前回審査会完了年月日を取得します。
     *
     * @return 前回審査会完了年月日
     */
    public FlexibleDate get前回審査会完了年月日() {
        return entity.getZennkai_20() == null ? FlexibleDate.EMPTY : entity.getZennkai_20();
    }

    /**
     * 前々回審査会完了年月日を取得します。
     *
     * @return 前々回審査会完了年月日
     */
    public FlexibleDate get前々回審査会完了年月日() {
        return entity.getZennnoma_20() == null ? FlexibleDate.EMPTY : entity.getZennnoma_20();
    }

    /**
     * 今回センター送信年月日を取得します。
     *
     * @return 今回センター送信年月日
     */
    public FlexibleDate get今回センター送信年月日() {
        return entity.getKonnkai_22() == null ? FlexibleDate.EMPTY : entity.getKonnkai_22();
    }

    /**
     * 前回センター送信年月日を取得します。
     *
     * @return 前回センター送信年月日
     */
    public FlexibleDate get前回センター送信年月日() {
        return entity.getZennkai_22() == null ? FlexibleDate.EMPTY : entity.getZennkai_22();
    }

    /**
     * 前々回センター送信年月日を取得します。
     *
     * @return 前々回センター送信年月日
     */
    public FlexibleDate get前々回センター送信年月日() {
        return entity.getZennnoma_22() == null ? FlexibleDate.EMPTY : entity.getZennnoma_22();
    }

    /**
     * 今回認定調査依頼予定年月日を取得します。
     *
     * @return 今回認定調査依頼予定年月日
     */
    public FlexibleDate get今回認定調査依頼予定年月日() {
        return entity.getKonnkai_2() == null ? FlexibleDate.EMPTY : entity.getKonnkai_2();
    }

    /**
     * 前回認定調査依頼予定年月日を取得します。
     *
     * @return 前回認定調査依頼予定年月日
     */
    public FlexibleDate get前回認定調査依頼予定年月日() {
        return entity.getZennkai_2() == null ? FlexibleDate.EMPTY : entity.getZennkai_2();
    }

    /**
     * 前々回認定調査依頼予定年月日を取得します。
     *
     * @return 前々回認定調査依頼予定年月日
     */
    public FlexibleDate get前々回認定調査依頼予定年月日() {
        return entity.getZennnoma_2() == null ? FlexibleDate.EMPTY : entity.getZennnoma_2();
    }

    /**
     * 今回認定調査予定年月日を取得します。
     *
     * @return 今回認定調査予定年月日
     */
    public FlexibleDate get今回認定調査予定年月日() {
        return entity.getKonnkai_5() == null ? FlexibleDate.EMPTY : entity.getKonnkai_5();
    }

    /**
     * 前回認定調査予定年月日を取得します。
     *
     * @return 前回認定調査予定年月日
     */
    public FlexibleDate get前回認定調査予定年月日() {
        return entity.getZennkai_5() == null ? FlexibleDate.EMPTY : entity.getZennkai_5();
    }

    /**
     * 前々回認定調査予定年月日を取得します。
     *
     * @return 前々回認定調査予定年月日
     */
    public FlexibleDate get前々回認定調査予定年月日() {
        return entity.getZennnoma_5() == null ? FlexibleDate.EMPTY : entity.getZennnoma_5();
    }

    /**
     * 今回主治医意見書作成依頼予定年月日を取得します。
     *
     * @return 今回主治医意見書作成依頼予定年月日
     */
    public FlexibleDate get今回主治医意見書作成依頼予定年月日() {
        return entity.getKonnkai_8() == null ? FlexibleDate.EMPTY : entity.getKonnkai_8();
    }

    /**
     * 前回主治医意見書作成依頼予定年月日を取得します。
     *
     * @return 前回主治医意見書作成依頼予定年月日
     */
    public FlexibleDate get前回主治医意見書作成依頼予定年月日() {
        return entity.getZennkai_8() == null ? FlexibleDate.EMPTY : entity.getZennkai_8();
    }

    /**
     * 前々回主治医意見書作成依頼予定年月日を取得します。
     *
     * @return 前々回主治医意見書作成依頼予定年月日
     */
    public FlexibleDate get前々回主治医意見書作成依頼予定年月日() {
        return entity.getZennnoma_8() == null ? FlexibleDate.EMPTY : entity.getZennnoma_8();
    }

    /**
     * 今回主治医意見書登録予定年月日を取得します。
     *
     * @return 今回主治医意見書登録予定年月日
     */
    public FlexibleDate get今回主治医意見書登録予定年月日() {
        return entity.getKonnkai_11() == null ? FlexibleDate.EMPTY : entity.getKonnkai_11();
    }

    /**
     * 前回主治医意見書登録予定年月日を取得します。
     *
     * @return 前回主治医意見書登録予定年月日
     */
    public FlexibleDate get前回主治医意見書登録予定年月日() {
        return entity.getZennkai_11() == null ? FlexibleDate.EMPTY : entity.getZennkai_11();
    }

    /**
     * 前々回主治医意見書登録予定年月日を取得します。
     *
     * @return 前々回主治医意見書登録予定年月日
     */
    public FlexibleDate get前々回主治医意見書登録予定年月日() {
        return entity.getZennnoma_11() == null ? FlexibleDate.EMPTY : entity.getZennnoma_11();
    }

    /**
     * 今回要介護認定一次判定予定年月日を取得します。
     *
     * @return 今回要介護認定一次判定予定年月日
     */
    public FlexibleDate get今回要介護認定一次判定予定年月日() {
        return entity.getKonnkai_14() == null ? FlexibleDate.EMPTY : entity.getKonnkai_14();
    }

    /**
     * 前回要介護認定一次判定予定年月日を取得します。
     *
     * @return 前回要介護認定一次判定予定年月日
     */
    public FlexibleDate get前回要介護認定一次判定予定年月日() {
        return entity.getZennkai_14() == null ? FlexibleDate.EMPTY : entity.getZennkai_14();
    }

    /**
     * 前々回要介護認定一次判定予定年月日を取得します。
     *
     * @return 前々回要介護認定一次判定予定年月日
     */
    public FlexibleDate get前々回要介護認定一次判定予定年月日() {
        return entity.getZennnoma_14() == null ? FlexibleDate.EMPTY : entity.getZennnoma_14();
    }

    /**
     * 今回認定審査会割当予定年月日を取得します。
     *
     * @return 今回認定審査会割当予定年月日
     */
    public FlexibleDate get今回認定審査会割当予定年月日() {
        return entity.getKonnkai_17() == null ? FlexibleDate.EMPTY : entity.getKonnkai_17();
    }

    /**
     * 前回認定審査会割当予定年月日を取得します。
     *
     * @return 前回認定審査会割当予定年月日
     */
    public FlexibleDate get前回認定審査会割当予定年月日() {
        return entity.getZennkai_17() == null ? FlexibleDate.EMPTY : entity.getZennkai_17();
    }

    /**
     * 前々回認定審査会割当予定年月日を取得します。
     *
     * @return 前々回認定審査会割当予定年月日
     */
    public FlexibleDate get前々回認定審査会割当予定年月日() {
        return entity.getZennnoma_17() == null ? FlexibleDate.EMPTY : entity.getZennnoma_17();
    }

    /**
     * 今回認定審査会予定年月日を取得します。
     *
     * @return 今回認定審査会予定年月日
     */
    public FlexibleDate get今回認定審査会予定年月日() {
        return entity.getKonnkai_18() == null ? FlexibleDate.EMPTY : entity.getKonnkai_18();
    }

    /**
     * 前回認定審査会予定年月日を取得します。
     *
     * @return 前回認定審査会予定年月日
     */
    public FlexibleDate get前回認定審査会予定年月日() {
        return entity.getZennkai_18() == null ? FlexibleDate.EMPTY : entity.getZennkai_18();
    }

    /**
     * 前々回認定審査会予定年月日を取得します。
     *
     * @return 前々回認定審査会予定年月日
     */
    public FlexibleDate get前々回認定審査会予定年月日() {
        return entity.getZennnoma_18() == null ? FlexibleDate.EMPTY : entity.getZennnoma_18();
    }

    /**
     * 今回センター送信予定年月日を取得します。
     *
     * @return 今回センター送信予定年月日
     */
    public FlexibleDate get今回センター送信予定年月日() {
        return entity.getKonnkai_21() == null ? FlexibleDate.EMPTY : entity.getKonnkai_21();
    }

    /**
     * 前回センター送信予定年月日を取得します。
     *
     * @return 前回センター送信予定年月日
     */
    public FlexibleDate get前回センター送信予定年月日() {
        return entity.getZennkai_21() == null ? FlexibleDate.EMPTY : entity.getZennkai_21();
    }

    /**
     * 前々回センター送信予定年月日を取得します。
     *
     * @return 前々回センター送信予定年月日
     */
    public FlexibleDate get前々回センター送信予定年月日() {
        return entity.getZennnoma_21() == null ? FlexibleDate.EMPTY : entity.getZennnoma_21();
    }

    /**
     * 今回認定調査依頼年月日を取得します。
     *
     * @return 今回認定調査依頼年月日
     */
    public FlexibleDate get今回認定調査依頼年月日() {
        return entity.getKonnkai_3() == null ? FlexibleDate.EMPTY : entity.getKonnkai_3();
    }

    /**
     * 前回認定調査依頼年月日を取得します。
     *
     * @return 前回認定調査依頼年月日
     */
    public FlexibleDate get前回認定調査依頼年月日() {
        return entity.getZennkai_3() == null ? FlexibleDate.EMPTY : entity.getZennkai_3();
    }

    /**
     * 前々回認定調査依頼年月日を取得します。
     *
     * @return 前々回認定調査依頼年月日
     */
    public FlexibleDate get前々回認定調査依頼年月日() {
        return entity.getZennnoma_3() == null ? FlexibleDate.EMPTY : entity.getZennnoma_3();
    }

    /**
     * 今回認定調査受領年月日を取得します。
     *
     * @return 今回認定調査受領年月日
     */
    public FlexibleDate get今回認定調査受領年月日() {
        return entity.getKonnkai_6() == null ? FlexibleDate.EMPTY : entity.getKonnkai_6();
    }

    /**
     * 前回認定調査受領年月日を取得します。
     *
     * @return 前回認定調査受領年月日
     */
    public FlexibleDate get前回認定調査受領年月日() {
        return entity.getZennkai_6() == null ? FlexibleDate.EMPTY : entity.getZennkai_6();
    }

    /**
     * 前々回認定調査受領年月日を取得します。
     *
     * @return 前々回認定調査受領年月日
     */
    public FlexibleDate get前々回認定調査受領年月日() {
        return entity.getZennnoma_6() == null ? FlexibleDate.EMPTY : entity.getZennnoma_6();
    }

    /**
     * 今回主治医意見書作成依頼年月日を取得します。
     *
     * @return 今回主治医意見書作成依頼年月日
     */
    public FlexibleDate get今回主治医意見書作成依頼年月日() {
        return entity.getKonnkai_9() == null ? FlexibleDate.EMPTY : entity.getKonnkai_9();
    }

    /**
     * 前回主治医意見書作成依頼年月日を取得します。
     *
     * @return 前回主治医意見書作成依頼年月日
     */
    public FlexibleDate get前回主治医意見書作成依頼年月日() {
        return entity.getZennkai_9() == null ? FlexibleDate.EMPTY : entity.getZennkai_9();
    }

    /**
     * 前々回主治医意見書作成依頼年月日を取得します。
     *
     * @return 前々回主治医意見書作成依頼年月日
     */
    public FlexibleDate get前々回主治医意見書作成依頼年月日() {
        return entity.getZennnoma_9() == null ? FlexibleDate.EMPTY : entity.getZennnoma_9();
    }

    /**
     * 今回主治医意見書受領年月日を取得します。
     *
     * @return 今回主治医意見書受領年月日
     */
    public FlexibleDate get今回主治医意見書受領年月日() {
        return entity.getKonnkai_12() == null ? FlexibleDate.EMPTY : entity.getKonnkai_12();
    }

    /**
     * 前回主治医意見書受領年月日を取得します。
     *
     * @return 前回主治医意見書受領年月日
     */
    public FlexibleDate get前回主治医意見書受領年月日() {
        return entity.getZennkai_12() == null ? FlexibleDate.EMPTY : entity.getZennkai_12();
    }

    /**
     * 前々回主治医意見書受領年月日を取得します。
     *
     * @return 前々回主治医意見書受領年月日
     */
    public FlexibleDate get前々回主治医意見書受領年月日() {
        return entity.getZennnoma_12() == null ? FlexibleDate.EMPTY : entity.getZennnoma_12();
    }
}
