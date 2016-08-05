/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaNinchishoKasanCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定審査対象者一覧表情報のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuShinsakaishiryoBusiness {

    private final IinShinsakaiIinJohoProcessParameter paramter;
    private final ShinsakaiTaiyosyaJohoEntity johoEntity;
    private final List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList;
    private final int no;
    private final int count;

    /**
     * コンストラクタです。
     *
     * @param paramter IinShinsakaiIinJohoMyBatisParameter
     * @param johoEntity ShinsakaiTaiyosyaJohoEntity
     * @param shinsakaiIinJohoList List<ShinsakaiIinJohoEntity>
     * @param no 審査対象者一覧No
     * @param count 審査対象者数
     */
    public JimuShinsakaishiryoBusiness(
            IinShinsakaiIinJohoProcessParameter paramter,
            ShinsakaiTaiyosyaJohoEntity johoEntity,
            List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList,
            int no,
            int count) {
        this.paramter = paramter;
        this.johoEntity = johoEntity;
        this.shinsakaiIinJohoList = shinsakaiIinJohoList;
        this.no = no;
        this.count = count;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return johoEntity.getShinseishoKanriNo();
    }

    /**
     * 審査会番号を取得します。
     *
     * @return 審査会番号
     */
    public RString get審査会番号() {
        return paramter.getShinsakaiKaisaiNo();
    }

    /**
     * 審査会開催年月日を取得します。
     *
     * @return 審査会開催年月日
     */
    public RString get審査会開催年月日() {
        return get開催年月日();
    }

    /**
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public RString get合議体番号() {
        return new RString(paramter.getGogitaiNo());
    }

    /**
     * 審査対象者数を取得します。
     *
     * @return 審査対象者数
     */
    public RString get審査対象者数() {
        return new RString(count);
    }

    /**
     * 審査員一覧を取得します。
     *
     * @return 審査員一覧
     */
    public RString get審査員一覧() {
        if (no < shinsakaiIinJohoList.size()) {
            return shinsakaiIinJohoList.get(no).getShinsakaiIinShimei().getColumnValue();
        }
        return RString.EMPTY;
    }

    /**
     * 番号を取得します。
     *
     * @return no
     */
    public int getNo() {
        return no + 1;
    }

    /**
     * 審査会審査順を取得します。
     *
     * @return 審査会審査順
     */
    public RString get審査会審査順() {
        return new RString(johoEntity.getShinsakaiOrder());
    }

    /**
     * 保険者を取得します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        return johoEntity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者を取得します。
     *
     * @return 被保険者
     */
    public RString get被保険者() {
        return johoEntity.getHihokenshaNo();
    }

    /**
     * 氏名を取得します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return johoEntity.getHihokenshaName().getColumnValue();
    }

    /**
     * 年齢を取得します。
     *
     * @return 年齢
     */
    public RString get年齢() {
        if (johoEntity.getAge() == 0) {
            return RString.EMPTY;
        }
        return new RString(johoEntity.getAge());
    }

    /**
     * 前回二次を取得します。
     *
     * @return 前回二次
     */
    public RString get前回二次() {
        return get要介護状態区分(johoEntity.getNijiHanteiYokaigoJotaiKubunCode());
    }

    /**
     * 前回期間を取得します。
     *
     * @return 前回期間
     */
    public RString get前回期間() {
        return get前回期間(johoEntity.getNijiHanteiNinteiYukoKikan());
    }

    /**
     * 一次判定を取得します。
     *
     * @return 一次判定
     */
    public RString get一次判定() {
        return get要介護認定一次判定結果(johoEntity.getIchijiHanteiKekkaCode(), johoEntity.getIchijiHanteiKekkaNinchishoKasanCode());
    }

    /**
     * 警告を取得します。
     *
     * @return 警告
     */
    public RString get警告() {
        if (RString.isNullOrEmpty(johoEntity.getIchijiHnateiKeikokuCode())) {
            return new RString("無");
        }
        return new RString("有");
    }

    /**
     * 基準時間を取得します。
     *
     * @return 基準時間
     */
    public RString get基準時間() {
        return new RString(johoEntity.getKijunJikan());
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return Seibetsu.toValue(johoEntity.getSeibetsu().getColumnValue()).get名称();
    }

    /**
     * 二次判定を取得します。
     *
     * @return 二次判定
     */
    public RString get二次判定() {
        return get要介護状態区分(johoEntity.getNijiHanteiYokaigoJotaiKubunCode());
    }

    /**
     * 事務局を判定します。
     *
     * @return is事務局、「true」を返却する場合、事務局です、それ以外、事務局ではない。
     */
    public boolean is事務局() {
        return johoEntity.isJimukyoku();
    }

    /**
     * 前回期間_下を取得します。
     *
     * @return 前回期間_下
     */
    public RString get前回期間_下() {
        RStringBuilder 前回期間_下 = new RStringBuilder();
        if (johoEntity.getNijiHanteiNinteiYukoKaishiYMD() != null && !johoEntity.getNijiHanteiNinteiYukoKaishiYMD().isEmpty()) {
            前回期間_下.append(パターン33(johoEntity.getNijiHanteiNinteiYukoKaishiYMD()));
        }
        if (johoEntity.getNijiHanteiNinteiYukoKaishiYMD() != null && !johoEntity.getNijiHanteiNinteiYukoKaishiYMD().isEmpty()
                && johoEntity.getNijiHanteiNinteiYukoShuryoYMD() != null && !johoEntity.getNijiHanteiNinteiYukoShuryoYMD().isEmpty()) {
            前回期間_下.append("～");
        }
        if (johoEntity.getNijiHanteiNinteiYukoShuryoYMD() != null && !johoEntity.getNijiHanteiNinteiYukoShuryoYMD().isEmpty()) {
            前回期間_下.append(パターン33(johoEntity.getNijiHanteiNinteiYukoShuryoYMD()));
        }
        return 前回期間_下.toRString();
    }

    private RString get前回期間(int 期間) {
        if (期間 == 0) {
            return RString.EMPTY;
        }
        RStringBuilder 前回期間 = new RStringBuilder();
        前回期間.append(期間);
        前回期間.append(new RString("ヵ月"));
        return 前回期間.toRString();
    }

    private RString get要介護状態区分(Code 状態区分コード) {
        if (状態区分コード != null && !状態区分コード.isEmpty()) {
            RStringBuilder 要介護状態区分 = new RStringBuilder("要介護状態区分コード");
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(状態区分コード.value())) {
                return 要介護状態区分.append(YokaigoJotaiKubun99.toValue(状態区分コード.value()).get名称()).toRString();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(状態区分コード.value())) {
                return 要介護状態区分.append(YokaigoJotaiKubun02.toValue(状態区分コード.value()).get名称()).toRString();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(状態区分コード.value())) {
                return 要介護状態区分.append(YokaigoJotaiKubun06.toValue(状態区分コード.value()).get名称()).toRString();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(状態区分コード.value())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(状態区分コード.value())) {
                return 要介護状態区分.append(YokaigoJotaiKubun09.toValue(状態区分コード.value()).get名称()).toRString();
            }
        }
        return RString.EMPTY;
    }

    private RString get要介護認定一次判定結果(Code 判定結果コード, Code 認知症加算コード) {
        RStringBuilder 判定結果 = new RStringBuilder();
        判定結果.append(IchijiHanteiKekkaCode09.toValue(判定結果コード.getColumnValue()).get名称()).toRString();
        if (!判定結果コード.equals(認知症加算コード)) {
            判定結果.append("→");
            判定結果.append(IchijiHanteiKekkaNinchishoKasanCode.toValue(認知症加算コード.value()).get名称());
        }
        return 判定結果.toRString();
    }

    private RString get開催年月日() {
        RStringBuilder 審査会開催年月日 = new RStringBuilder();
        審査会開催年月日.append(パターン33(paramter.getShinsakaiKaisaiYoteiYMD()));
        審査会開催年月日.append(paramter.getShinsakaiKaishiYoteiTime().substring(0, 2));
        審査会開催年月日.append(new RString("時"));
        審査会開催年月日.append(paramter.getShinsakaiKaishiYoteiTime().substring(2));
        審査会開催年月日.append(new RString("分"));
        return 審査会開催年月日.toRString();
    }

    private RString パターン33(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.seireki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }
}
