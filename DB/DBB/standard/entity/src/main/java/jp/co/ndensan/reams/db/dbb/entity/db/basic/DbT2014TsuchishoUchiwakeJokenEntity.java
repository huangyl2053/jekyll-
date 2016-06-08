package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 通知書打ち分け条件テーブルのエンティティクラスです。
 * <br/> 決定通知書・変更通知書を任意の条件で打ち分けする際の条件を保存するテーブル。
 */
public class DbT2014TsuchishoUchiwakeJokenEntity extends DbTableEntityBase<DbT2014TsuchishoUchiwakeJokenEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT2014TsuchishoUchiwakeJoken");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString uchiwakeJoken;
    @PrimaryKey
    private RDateTime hozonDateTime;
    @PrimaryKey
    private RString fukaShoriKubun;
    private RString selectTsuchisho01;
    private RString selectGenkinKoza01;
    private RString sortGroupName01;
    private RString selectTsuchisho02;
    private RString selectGenkinKoza02;
    private RString sortGroupName02;
    private RString selectTsuchisho03;
    private RString selectGenkinKoza03;
    private RString sortGroupName03;
    private RString selectTsuchisho04;
    private RString selectGenkinKoza04;
    private RString sortGroupName04;
    private RString selectTsuchisho05;
    private RString selectGenkinKoza05;
    private RString sortGroupName05;
    private RString selectTsuchisho06;
    private RString selectGenkinKoza06;
    private RString sortGroupName06;
    private RString selectTsuchisho07;
    private RString selectGenkinKoza07;
    private RString sortGroupName07;
    private RString selectTsuchisho08;
    private RString selectGenkinKoza08;
    private RString sortGroupName08;
    private RString selectTsuchisho09;
    private RString selectGenkinKoza09;
    private RString sortGroupName09;
    private RString selectTsuchisho10;
    private RString selectGenkinKoza10;
    private RString sortGroupName10;
    private RString selectTsuchisho11;
    private RString selectGenkinKoza11;
    private RString sortGroupName11;
    private RString selectTsuchisho12;
    private RString selectGenkinKoza12;
    private RString sortGroupName12;
    private RString selectTsuchisho13;
    private RString selectGenkinKoza13;
    private RString sortGroupName13;
    private RString selectTsuchisho14;
    private RString selectGenkinKoza14;
    private RString sortGroupName14;
    private RString selectTsuchisho15;
    private RString selectGenkinKoza15;
    private RString sortGroupName15;

    /**
     * insertDantaiCdのgetメソッドです。
     * 
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     * 
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     * 
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     * 
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     * 
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 打ち分け条件のgetメソッドです。
     * <br/>
     * <br/>任意で付けられた通知書を打ち分けるための条件の名称
     * 
     * @return 打ち分け条件
     */
    public RString getUchiwakeJoken() {
        return uchiwakeJoken;
    }

    /**
     * 打ち分け条件のsetメソッドです。
     * <br/>
     * <br/>任意で付けられた通知書を打ち分けるための条件の名称
     * 
     * @param uchiwakeJoken 打ち分け条件
     */
    public void setUchiwakeJoken(@Nonnull RString uchiwakeJoken) {
        this.uchiwakeJoken = uchiwakeJoken;
    }

    /**
     * 保存日時のgetメソッドです。
     * 
     * @return 保存日時
     */
    public RDateTime getHozonDateTime() {
        return hozonDateTime;
    }

    /**
     * 保存日時のsetメソッドです。
     * 
     * @param hozonDateTime 保存日時
     */
    public void setHozonDateTime(@Nonnull RDateTime hozonDateTime) {
        this.hozonDateTime = hozonDateTime;
    }

    /**
     * 賦課処理区分のgetメソッドです。
     * <br/>
     * <br/>0:本算定賦課、1:異動賦課
     * 
     * @return 賦課処理区分
     */
    public RString getFukaShoriKubun() {
        return fukaShoriKubun;
    }

    /**
     * 賦課処理区分のsetメソッドです。
     * <br/>
     * <br/>0:本算定賦課、1:異動賦課
     * 
     * @param fukaShoriKubun 賦課処理区分
     */
    public void setFukaShoriKubun(@Nonnull RString fukaShoriKubun) {
        this.fukaShoriKubun = fukaShoriKubun;
    }

    /**
     * 選択通知書01のgetメソッドです。
     * <br/>
     * <br/>0:発行しない、1:決定通知書、2：変更通知書（以下同様）
     * 
     * @return 選択通知書01
     */
    @CheckForNull
    public RString getSelectTsuchisho01() {
        return selectTsuchisho01;
    }

    /**
     * 選択通知書01のsetメソッドです。
     * <br/>
     * <br/>0:発行しない、1:決定通知書、2：変更通知書（以下同様）
     * 
     * @param selectTsuchisho01 選択通知書01
     */
    public void setSelectTsuchisho01(RString selectTsuchisho01) {
        this.selectTsuchisho01 = selectTsuchisho01;
    }

    /**
     * 選択現金口座01のgetメソッドです。
     * <br/>
     * <br/>0:現金、1:口座、2:全て（以下同様）
     * 
     * @return 選択現金口座01
     */
    @CheckForNull
    public RString getSelectGenkinKoza01() {
        return selectGenkinKoza01;
    }

    /**
     * 選択現金口座01のsetメソッドです。
     * <br/>
     * <br/>0:現金、1:口座、2:全て（以下同様）
     * 
     * @param selectGenkinKoza01 選択現金口座01
     */
    public void setSelectGenkinKoza01(RString selectGenkinKoza01) {
        this.selectGenkinKoza01 = selectGenkinKoza01;
    }

    /**
     * 出力順グループ名01のgetメソッドです。
     * 
     * @return 出力順グループ名01
     */
    @CheckForNull
    public RString getSortGroupName01() {
        return sortGroupName01;
    }

    /**
     * 出力順グループ名01のsetメソッドです。
     * 
     * @param sortGroupName01 出力順グループ名01
     */
    public void setSortGroupName01(RString sortGroupName01) {
        this.sortGroupName01 = sortGroupName01;
    }

    /**
     * 選択通知書02のgetメソッドです。
     * 
     * @return 選択通知書02
     */
    @CheckForNull
    public RString getSelectTsuchisho02() {
        return selectTsuchisho02;
    }

    /**
     * 選択通知書02のsetメソッドです。
     * 
     * @param selectTsuchisho02 選択通知書02
     */
    public void setSelectTsuchisho02(RString selectTsuchisho02) {
        this.selectTsuchisho02 = selectTsuchisho02;
    }

    /**
     * 選択現金口座02のgetメソッドです。
     * 
     * @return 選択現金口座02
     */
    @CheckForNull
    public RString getSelectGenkinKoza02() {
        return selectGenkinKoza02;
    }

    /**
     * 選択現金口座02のsetメソッドです。
     * 
     * @param selectGenkinKoza02 選択現金口座02
     */
    public void setSelectGenkinKoza02(RString selectGenkinKoza02) {
        this.selectGenkinKoza02 = selectGenkinKoza02;
    }

    /**
     * 出力順グループ名02のgetメソッドです。
     * 
     * @return 出力順グループ名02
     */
    @CheckForNull
    public RString getSortGroupName02() {
        return sortGroupName02;
    }

    /**
     * 出力順グループ名02のsetメソッドです。
     * 
     * @param sortGroupName02 出力順グループ名02
     */
    public void setSortGroupName02(RString sortGroupName02) {
        this.sortGroupName02 = sortGroupName02;
    }

    /**
     * 選択通知書03のgetメソッドです。
     * 
     * @return 選択通知書03
     */
    @CheckForNull
    public RString getSelectTsuchisho03() {
        return selectTsuchisho03;
    }

    /**
     * 選択通知書03のsetメソッドです。
     * 
     * @param selectTsuchisho03 選択通知書03
     */
    public void setSelectTsuchisho03(RString selectTsuchisho03) {
        this.selectTsuchisho03 = selectTsuchisho03;
    }

    /**
     * 選択現金口座03のgetメソッドです。
     * 
     * @return 選択現金口座03
     */
    @CheckForNull
    public RString getSelectGenkinKoza03() {
        return selectGenkinKoza03;
    }

    /**
     * 選択現金口座03のsetメソッドです。
     * 
     * @param selectGenkinKoza03 選択現金口座03
     */
    public void setSelectGenkinKoza03(RString selectGenkinKoza03) {
        this.selectGenkinKoza03 = selectGenkinKoza03;
    }

    /**
     * 出力順グループ名03のgetメソッドです。
     * 
     * @return 出力順グループ名03
     */
    @CheckForNull
    public RString getSortGroupName03() {
        return sortGroupName03;
    }

    /**
     * 出力順グループ名03のsetメソッドです。
     * 
     * @param sortGroupName03 出力順グループ名03
     */
    public void setSortGroupName03(RString sortGroupName03) {
        this.sortGroupName03 = sortGroupName03;
    }

    /**
     * 選択通知書04のgetメソッドです。
     * 
     * @return 選択通知書04
     */
    @CheckForNull
    public RString getSelectTsuchisho04() {
        return selectTsuchisho04;
    }

    /**
     * 選択通知書04のsetメソッドです。
     * 
     * @param selectTsuchisho04 選択通知書04
     */
    public void setSelectTsuchisho04(RString selectTsuchisho04) {
        this.selectTsuchisho04 = selectTsuchisho04;
    }

    /**
     * 選択現金口座04のgetメソッドです。
     * 
     * @return 選択現金口座04
     */
    @CheckForNull
    public RString getSelectGenkinKoza04() {
        return selectGenkinKoza04;
    }

    /**
     * 選択現金口座04のsetメソッドです。
     * 
     * @param selectGenkinKoza04 選択現金口座04
     */
    public void setSelectGenkinKoza04(RString selectGenkinKoza04) {
        this.selectGenkinKoza04 = selectGenkinKoza04;
    }

    /**
     * 出力順グループ名04のgetメソッドです。
     * 
     * @return 出力順グループ名04
     */
    @CheckForNull
    public RString getSortGroupName04() {
        return sortGroupName04;
    }

    /**
     * 出力順グループ名04のsetメソッドです。
     * 
     * @param sortGroupName04 出力順グループ名04
     */
    public void setSortGroupName04(RString sortGroupName04) {
        this.sortGroupName04 = sortGroupName04;
    }

    /**
     * 選択通知書05のgetメソッドです。
     * 
     * @return 選択通知書05
     */
    @CheckForNull
    public RString getSelectTsuchisho05() {
        return selectTsuchisho05;
    }

    /**
     * 選択通知書05のsetメソッドです。
     * 
     * @param selectTsuchisho05 選択通知書05
     */
    public void setSelectTsuchisho05(RString selectTsuchisho05) {
        this.selectTsuchisho05 = selectTsuchisho05;
    }

    /**
     * 選択現金口座05のgetメソッドです。
     * 
     * @return 選択現金口座05
     */
    @CheckForNull
    public RString getSelectGenkinKoza05() {
        return selectGenkinKoza05;
    }

    /**
     * 選択現金口座05のsetメソッドです。
     * 
     * @param selectGenkinKoza05 選択現金口座05
     */
    public void setSelectGenkinKoza05(RString selectGenkinKoza05) {
        this.selectGenkinKoza05 = selectGenkinKoza05;
    }

    /**
     * 出力順グループ名05のgetメソッドです。
     * 
     * @return 出力順グループ名05
     */
    @CheckForNull
    public RString getSortGroupName05() {
        return sortGroupName05;
    }

    /**
     * 出力順グループ名05のsetメソッドです。
     * 
     * @param sortGroupName05 出力順グループ名05
     */
    public void setSortGroupName05(RString sortGroupName05) {
        this.sortGroupName05 = sortGroupName05;
    }

    /**
     * 選択通知書06のgetメソッドです。
     * 
     * @return 選択通知書06
     */
    @CheckForNull
    public RString getSelectTsuchisho06() {
        return selectTsuchisho06;
    }

    /**
     * 選択通知書06のsetメソッドです。
     * 
     * @param selectTsuchisho06 選択通知書06
     */
    public void setSelectTsuchisho06(RString selectTsuchisho06) {
        this.selectTsuchisho06 = selectTsuchisho06;
    }

    /**
     * 選択現金口座06のgetメソッドです。
     * 
     * @return 選択現金口座06
     */
    @CheckForNull
    public RString getSelectGenkinKoza06() {
        return selectGenkinKoza06;
    }

    /**
     * 選択現金口座06のsetメソッドです。
     * 
     * @param selectGenkinKoza06 選択現金口座06
     */
    public void setSelectGenkinKoza06(RString selectGenkinKoza06) {
        this.selectGenkinKoza06 = selectGenkinKoza06;
    }

    /**
     * 出力順グループ名06のgetメソッドです。
     * 
     * @return 出力順グループ名06
     */
    @CheckForNull
    public RString getSortGroupName06() {
        return sortGroupName06;
    }

    /**
     * 出力順グループ名06のsetメソッドです。
     * 
     * @param sortGroupName06 出力順グループ名06
     */
    public void setSortGroupName06(RString sortGroupName06) {
        this.sortGroupName06 = sortGroupName06;
    }

    /**
     * 選択通知書07のgetメソッドです。
     * 
     * @return 選択通知書07
     */
    @CheckForNull
    public RString getSelectTsuchisho07() {
        return selectTsuchisho07;
    }

    /**
     * 選択通知書07のsetメソッドです。
     * 
     * @param selectTsuchisho07 選択通知書07
     */
    public void setSelectTsuchisho07(RString selectTsuchisho07) {
        this.selectTsuchisho07 = selectTsuchisho07;
    }

    /**
     * 選択現金口座07のgetメソッドです。
     * 
     * @return 選択現金口座07
     */
    @CheckForNull
    public RString getSelectGenkinKoza07() {
        return selectGenkinKoza07;
    }

    /**
     * 選択現金口座07のsetメソッドです。
     * 
     * @param selectGenkinKoza07 選択現金口座07
     */
    public void setSelectGenkinKoza07(RString selectGenkinKoza07) {
        this.selectGenkinKoza07 = selectGenkinKoza07;
    }

    /**
     * 出力順グループ名07のgetメソッドです。
     * 
     * @return 出力順グループ名07
     */
    @CheckForNull
    public RString getSortGroupName07() {
        return sortGroupName07;
    }

    /**
     * 出力順グループ名07のsetメソッドです。
     * 
     * @param sortGroupName07 出力順グループ名07
     */
    public void setSortGroupName07(RString sortGroupName07) {
        this.sortGroupName07 = sortGroupName07;
    }

    /**
     * 選択通知書08のgetメソッドです。
     * 
     * @return 選択通知書08
     */
    @CheckForNull
    public RString getSelectTsuchisho08() {
        return selectTsuchisho08;
    }

    /**
     * 選択通知書08のsetメソッドです。
     * 
     * @param selectTsuchisho08 選択通知書08
     */
    public void setSelectTsuchisho08(RString selectTsuchisho08) {
        this.selectTsuchisho08 = selectTsuchisho08;
    }

    /**
     * 選択現金口座08のgetメソッドです。
     * 
     * @return 選択現金口座08
     */
    @CheckForNull
    public RString getSelectGenkinKoza08() {
        return selectGenkinKoza08;
    }

    /**
     * 選択現金口座08のsetメソッドです。
     * 
     * @param selectGenkinKoza08 選択現金口座08
     */
    public void setSelectGenkinKoza08(RString selectGenkinKoza08) {
        this.selectGenkinKoza08 = selectGenkinKoza08;
    }

    /**
     * 出力順グループ名08のgetメソッドです。
     * 
     * @return 出力順グループ名08
     */
    @CheckForNull
    public RString getSortGroupName08() {
        return sortGroupName08;
    }

    /**
     * 出力順グループ名08のsetメソッドです。
     * 
     * @param sortGroupName08 出力順グループ名08
     */
    public void setSortGroupName08(RString sortGroupName08) {
        this.sortGroupName08 = sortGroupName08;
    }

    /**
     * 選択通知書09のgetメソッドです。
     * 
     * @return 選択通知書09
     */
    @CheckForNull
    public RString getSelectTsuchisho09() {
        return selectTsuchisho09;
    }

    /**
     * 選択通知書09のsetメソッドです。
     * 
     * @param selectTsuchisho09 選択通知書09
     */
    public void setSelectTsuchisho09(RString selectTsuchisho09) {
        this.selectTsuchisho09 = selectTsuchisho09;
    }

    /**
     * 選択現金口座09のgetメソッドです。
     * 
     * @return 選択現金口座09
     */
    @CheckForNull
    public RString getSelectGenkinKoza09() {
        return selectGenkinKoza09;
    }

    /**
     * 選択現金口座09のsetメソッドです。
     * 
     * @param selectGenkinKoza09 選択現金口座09
     */
    public void setSelectGenkinKoza09(RString selectGenkinKoza09) {
        this.selectGenkinKoza09 = selectGenkinKoza09;
    }

    /**
     * 出力順グループ名09のgetメソッドです。
     * 
     * @return 出力順グループ名09
     */
    @CheckForNull
    public RString getSortGroupName09() {
        return sortGroupName09;
    }

    /**
     * 出力順グループ名09のsetメソッドです。
     * 
     * @param sortGroupName09 出力順グループ名09
     */
    public void setSortGroupName09(RString sortGroupName09) {
        this.sortGroupName09 = sortGroupName09;
    }

    /**
     * 選択通知書10のgetメソッドです。
     * 
     * @return 選択通知書10
     */
    @CheckForNull
    public RString getSelectTsuchisho10() {
        return selectTsuchisho10;
    }

    /**
     * 選択通知書10のsetメソッドです。
     * 
     * @param selectTsuchisho10 選択通知書10
     */
    public void setSelectTsuchisho10(RString selectTsuchisho10) {
        this.selectTsuchisho10 = selectTsuchisho10;
    }

    /**
     * 選択現金口座10のgetメソッドです。
     * 
     * @return 選択現金口座10
     */
    @CheckForNull
    public RString getSelectGenkinKoza10() {
        return selectGenkinKoza10;
    }

    /**
     * 選択現金口座10のsetメソッドです。
     * 
     * @param selectGenkinKoza10 選択現金口座10
     */
    public void setSelectGenkinKoza10(RString selectGenkinKoza10) {
        this.selectGenkinKoza10 = selectGenkinKoza10;
    }

    /**
     * 出力順グループ名10のgetメソッドです。
     * 
     * @return 出力順グループ名10
     */
    @CheckForNull
    public RString getSortGroupName10() {
        return sortGroupName10;
    }

    /**
     * 出力順グループ名10のsetメソッドです。
     * 
     * @param sortGroupName10 出力順グループ名10
     */
    public void setSortGroupName10(RString sortGroupName10) {
        this.sortGroupName10 = sortGroupName10;
    }

    /**
     * 選択通知書11のgetメソッドです。
     * 
     * @return 選択通知書11
     */
    @CheckForNull
    public RString getSelectTsuchisho11() {
        return selectTsuchisho11;
    }

    /**
     * 選択通知書11のsetメソッドです。
     * 
     * @param selectTsuchisho11 選択通知書11
     */
    public void setSelectTsuchisho11(RString selectTsuchisho11) {
        this.selectTsuchisho11 = selectTsuchisho11;
    }

    /**
     * 選択現金口座11のgetメソッドです。
     * 
     * @return 選択現金口座11
     */
    @CheckForNull
    public RString getSelectGenkinKoza11() {
        return selectGenkinKoza11;
    }

    /**
     * 選択現金口座11のsetメソッドです。
     * 
     * @param selectGenkinKoza11 選択現金口座11
     */
    public void setSelectGenkinKoza11(RString selectGenkinKoza11) {
        this.selectGenkinKoza11 = selectGenkinKoza11;
    }

    /**
     * 出力順グループ名11のgetメソッドです。
     * 
     * @return 出力順グループ名11
     */
    @CheckForNull
    public RString getSortGroupName11() {
        return sortGroupName11;
    }

    /**
     * 出力順グループ名11のsetメソッドです。
     * 
     * @param sortGroupName11 出力順グループ名11
     */
    public void setSortGroupName11(RString sortGroupName11) {
        this.sortGroupName11 = sortGroupName11;
    }

    /**
     * 選択通知書12のgetメソッドです。
     * 
     * @return 選択通知書12
     */
    @CheckForNull
    public RString getSelectTsuchisho12() {
        return selectTsuchisho12;
    }

    /**
     * 選択通知書12のsetメソッドです。
     * 
     * @param selectTsuchisho12 選択通知書12
     */
    public void setSelectTsuchisho12(RString selectTsuchisho12) {
        this.selectTsuchisho12 = selectTsuchisho12;
    }

    /**
     * 選択現金口座12のgetメソッドです。
     * 
     * @return 選択現金口座12
     */
    @CheckForNull
    public RString getSelectGenkinKoza12() {
        return selectGenkinKoza12;
    }

    /**
     * 選択現金口座12のsetメソッドです。
     * 
     * @param selectGenkinKoza12 選択現金口座12
     */
    public void setSelectGenkinKoza12(RString selectGenkinKoza12) {
        this.selectGenkinKoza12 = selectGenkinKoza12;
    }

    /**
     * 出力順グループ名12のgetメソッドです。
     * 
     * @return 出力順グループ名12
     */
    @CheckForNull
    public RString getSortGroupName12() {
        return sortGroupName12;
    }

    /**
     * 出力順グループ名12のsetメソッドです。
     * 
     * @param sortGroupName12 出力順グループ名12
     */
    public void setSortGroupName12(RString sortGroupName12) {
        this.sortGroupName12 = sortGroupName12;
    }

    /**
     * 選択通知書13のgetメソッドです。
     * 
     * @return 選択通知書13
     */
    @CheckForNull
    public RString getSelectTsuchisho13() {
        return selectTsuchisho13;
    }

    /**
     * 選択通知書13のsetメソッドです。
     * 
     * @param selectTsuchisho13 選択通知書13
     */
    public void setSelectTsuchisho13(RString selectTsuchisho13) {
        this.selectTsuchisho13 = selectTsuchisho13;
    }

    /**
     * 選択現金口座13のgetメソッドです。
     * 
     * @return 選択現金口座13
     */
    @CheckForNull
    public RString getSelectGenkinKoza13() {
        return selectGenkinKoza13;
    }

    /**
     * 選択現金口座13のsetメソッドです。
     * 
     * @param selectGenkinKoza13 選択現金口座13
     */
    public void setSelectGenkinKoza13(RString selectGenkinKoza13) {
        this.selectGenkinKoza13 = selectGenkinKoza13;
    }

    /**
     * 出力順グループ名13のgetメソッドです。
     * 
     * @return 出力順グループ名13
     */
    @CheckForNull
    public RString getSortGroupName13() {
        return sortGroupName13;
    }

    /**
     * 出力順グループ名13のsetメソッドです。
     * 
     * @param sortGroupName13 出力順グループ名13
     */
    public void setSortGroupName13(RString sortGroupName13) {
        this.sortGroupName13 = sortGroupName13;
    }

    /**
     * 選択通知書14のgetメソッドです。
     * 
     * @return 選択通知書14
     */
    @CheckForNull
    public RString getSelectTsuchisho14() {
        return selectTsuchisho14;
    }

    /**
     * 選択通知書14のsetメソッドです。
     * 
     * @param selectTsuchisho14 選択通知書14
     */
    public void setSelectTsuchisho14(RString selectTsuchisho14) {
        this.selectTsuchisho14 = selectTsuchisho14;
    }

    /**
     * 選択現金口座14のgetメソッドです。
     * 
     * @return 選択現金口座14
     */
    @CheckForNull
    public RString getSelectGenkinKoza14() {
        return selectGenkinKoza14;
    }

    /**
     * 選択現金口座14のsetメソッドです。
     * 
     * @param selectGenkinKoza14 選択現金口座14
     */
    public void setSelectGenkinKoza14(RString selectGenkinKoza14) {
        this.selectGenkinKoza14 = selectGenkinKoza14;
    }

    /**
     * 出力順グループ名14のgetメソッドです。
     * 
     * @return 出力順グループ名14
     */
    @CheckForNull
    public RString getSortGroupName14() {
        return sortGroupName14;
    }

    /**
     * 出力順グループ名14のsetメソッドです。
     * 
     * @param sortGroupName14 出力順グループ名14
     */
    public void setSortGroupName14(RString sortGroupName14) {
        this.sortGroupName14 = sortGroupName14;
    }

    /**
     * 選択通知書15のgetメソッドです。
     * 
     * @return 選択通知書15
     */
    @CheckForNull
    public RString getSelectTsuchisho15() {
        return selectTsuchisho15;
    }

    /**
     * 選択通知書15のsetメソッドです。
     * 
     * @param selectTsuchisho15 選択通知書15
     */
    public void setSelectTsuchisho15(RString selectTsuchisho15) {
        this.selectTsuchisho15 = selectTsuchisho15;
    }

    /**
     * 選択現金口座15のgetメソッドです。
     * 
     * @return 選択現金口座15
     */
    @CheckForNull
    public RString getSelectGenkinKoza15() {
        return selectGenkinKoza15;
    }

    /**
     * 選択現金口座15のsetメソッドです。
     * 
     * @param selectGenkinKoza15 選択現金口座15
     */
    public void setSelectGenkinKoza15(RString selectGenkinKoza15) {
        this.selectGenkinKoza15 = selectGenkinKoza15;
    }

    /**
     * 出力順グループ名15のgetメソッドです。
     * 
     * @return 出力順グループ名15
     */
    @CheckForNull
    public RString getSortGroupName15() {
        return sortGroupName15;
    }

    /**
     * 出力順グループ名15のsetメソッドです。
     * 
     * @param sortGroupName15 出力順グループ名15
     */
    public void setSortGroupName15(RString sortGroupName15) {
        this.sortGroupName15 = sortGroupName15;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2014TsuchishoUchiwakeJokenEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2014TsuchishoUchiwakeJokenEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2014TsuchishoUchiwakeJokenEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.uchiwakeJoken, other.uchiwakeJoken)) {
            return false;
        }
        if (!Objects.equals(this.hozonDateTime, other.hozonDateTime)) {
            return false;
        }
        if (!Objects.equals(this.fukaShoriKubun, other.fukaShoriKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT2014TsuchishoUchiwakeJokenEntity entity) {
        this.uchiwakeJoken = entity.uchiwakeJoken;
        this.hozonDateTime = entity.hozonDateTime;
        this.fukaShoriKubun = entity.fukaShoriKubun;
        this.selectTsuchisho01 = entity.selectTsuchisho01;
        this.selectGenkinKoza01 = entity.selectGenkinKoza01;
        this.sortGroupName01 = entity.sortGroupName01;
        this.selectTsuchisho02 = entity.selectTsuchisho02;
        this.selectGenkinKoza02 = entity.selectGenkinKoza02;
        this.sortGroupName02 = entity.sortGroupName02;
        this.selectTsuchisho03 = entity.selectTsuchisho03;
        this.selectGenkinKoza03 = entity.selectGenkinKoza03;
        this.sortGroupName03 = entity.sortGroupName03;
        this.selectTsuchisho04 = entity.selectTsuchisho04;
        this.selectGenkinKoza04 = entity.selectGenkinKoza04;
        this.sortGroupName04 = entity.sortGroupName04;
        this.selectTsuchisho05 = entity.selectTsuchisho05;
        this.selectGenkinKoza05 = entity.selectGenkinKoza05;
        this.sortGroupName05 = entity.sortGroupName05;
        this.selectTsuchisho06 = entity.selectTsuchisho06;
        this.selectGenkinKoza06 = entity.selectGenkinKoza06;
        this.sortGroupName06 = entity.sortGroupName06;
        this.selectTsuchisho07 = entity.selectTsuchisho07;
        this.selectGenkinKoza07 = entity.selectGenkinKoza07;
        this.sortGroupName07 = entity.sortGroupName07;
        this.selectTsuchisho08 = entity.selectTsuchisho08;
        this.selectGenkinKoza08 = entity.selectGenkinKoza08;
        this.sortGroupName08 = entity.sortGroupName08;
        this.selectTsuchisho09 = entity.selectTsuchisho09;
        this.selectGenkinKoza09 = entity.selectGenkinKoza09;
        this.sortGroupName09 = entity.sortGroupName09;
        this.selectTsuchisho10 = entity.selectTsuchisho10;
        this.selectGenkinKoza10 = entity.selectGenkinKoza10;
        this.sortGroupName10 = entity.sortGroupName10;
        this.selectTsuchisho11 = entity.selectTsuchisho11;
        this.selectGenkinKoza11 = entity.selectGenkinKoza11;
        this.sortGroupName11 = entity.sortGroupName11;
        this.selectTsuchisho12 = entity.selectTsuchisho12;
        this.selectGenkinKoza12 = entity.selectGenkinKoza12;
        this.sortGroupName12 = entity.sortGroupName12;
        this.selectTsuchisho13 = entity.selectTsuchisho13;
        this.selectGenkinKoza13 = entity.selectGenkinKoza13;
        this.sortGroupName13 = entity.sortGroupName13;
        this.selectTsuchisho14 = entity.selectTsuchisho14;
        this.selectGenkinKoza14 = entity.selectGenkinKoza14;
        this.sortGroupName14 = entity.sortGroupName14;
        this.selectTsuchisho15 = entity.selectTsuchisho15;
        this.selectGenkinKoza15 = entity.selectGenkinKoza15;
        this.sortGroupName15 = entity.sortGroupName15;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(uchiwakeJoken, hozonDateTime, fukaShoriKubun, selectTsuchisho01, selectGenkinKoza01, sortGroupName01, selectTsuchisho02, selectGenkinKoza02, sortGroupName02, selectTsuchisho03, selectGenkinKoza03, sortGroupName03, selectTsuchisho04, selectGenkinKoza04, sortGroupName04, selectTsuchisho05, selectGenkinKoza05, sortGroupName05, selectTsuchisho06, selectGenkinKoza06, sortGroupName06, selectTsuchisho07, selectGenkinKoza07, sortGroupName07, selectTsuchisho08, selectGenkinKoza08, sortGroupName08, selectTsuchisho09, selectGenkinKoza09, sortGroupName09, selectTsuchisho10, selectGenkinKoza10, sortGroupName10, selectTsuchisho11, selectGenkinKoza11, sortGroupName11, selectTsuchisho12, selectGenkinKoza12, sortGroupName12, selectTsuchisho13, selectGenkinKoza13, sortGroupName13, selectTsuchisho14, selectGenkinKoza14, sortGroupName14, selectTsuchisho15, selectGenkinKoza15, sortGroupName15);
    }

// </editor-fold>
}
